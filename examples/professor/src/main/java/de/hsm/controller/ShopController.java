package de.hsm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hsm.logic.*;
import de.hsm.model.ProductBean;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {

	@GetMapping("/products")
	public ModelAndView searchProducts() {
		ModelAndView mv = new ModelAndView("products");
		List<Book> products = new ArrayList<>();
		mv.addObject("products", products);
		mv.addObject("productBean", new ProductBean());
		mv.addObject("searchOptions", getSearchOptions());
		return mv;
	}

	private Map<String, String> getSearchOptions() {
		Map<String, String> searchOptions = new HashMap<>();
		searchOptions.put("title", "search in Title");
		searchOptions.put("author", "search in Author");
		searchOptions.put("both", "search in both");
		return searchOptions;
	}

	@PostMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam(value = "selectedProduct") String selectedProduct,
			HttpSession session) {
		String[] parts = selectedProduct.split(" ");
		String action = parts[0];
		String isbn13 = parts[1];
		ModelAndView mv = new ModelAndView();
		if (action.equals("show")) {
			mv.setViewName("redirect:/bookDetails/" + isbn13 + "/product list");
			return mv;
		}
		mv.setViewName("products");
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		ShopService shopService = new ShopService();
		Book book = shopService.findBook(isbn13);
		shoppingCart.addItem(book, 1);
		mv.addObject("successMessage", "Book added to shopping cart");
		List<Book> products = (List<Book>)session.getAttribute("products");
		mv.addObject("products", products);
		mv.addObject("productBean", new ProductBean());
		mv.addObject("searchOptions", getSearchOptions());
		return mv;
	}

	@GetMapping("/shoppingCart")
	public ModelAndView showShoppingCart(HttpSession session) {
		ModelAndView mv = new ModelAndView("shoppingCart");
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingCart", shoppingCart);
		}
		List<Item> items = shoppingCart.getItems();
		if (items.isEmpty()) {
			mv.addObject("errorMessage", "Shopping cart is empty");
		}
		mv.addObject("items", items);
		return mv;
	}

	@PostMapping("/handleItem")
	public ModelAndView handleItem(@RequestParam(value = "showItem",  required=false) String isbn13, @RequestParam(value = "deleteItem", required = false) Integer index, HttpSession session) {
		ModelAndView mv = new ModelAndView("shoppingCart");
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		List<Item> items = shoppingCart.getItems();
		if (items.isEmpty()) {
			mv.addObject("errorMessage", "No product deleted");
		} else if (isbn13 != null){
			mv.setViewName("redirect:/bookDetails/" + isbn13 + "/shopping cart");
		} else {
			if (index != null && index >= 0 && index < items.size()){
				int idx = index.intValue();
				items.remove(idx);
				mv.addObject("successMessage", "Product deleted from shopping cart");
			}
		}
		mv.addObject("items", items);
		return mv;
	}

	@GetMapping("/bookDetails/{isbn13}/{source}")
	public ModelAndView showBookDetails(@PathVariable("isbn13") String isbn13, @PathVariable("source") String source) {
		ModelAndView mv = new ModelAndView("bookDetails");
		try {
			Book book = new ShopService().findBook(isbn13);
			mv.addObject("book", book);
			mv.addObject("authors", book.getAuthors());
			mv.addObject("source", source);
			return mv;
		} catch (Exception e) {
			mv.addObject("errorMessage", "Unknown error occurred");
			mv.addObject("book", new Book());
			return mv;
		}
	}
	
	@PostMapping("/backToSource/{source}")
	public String backToSource(@PathVariable("source") String source) {
		if (source.equals("product list")) {
			return "redirect:/products";
		} else {
			return "redirect:/shoppingCart";
		}
	}

}
