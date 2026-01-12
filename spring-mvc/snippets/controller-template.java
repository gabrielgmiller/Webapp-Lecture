package YOUR.PACKAGE.HERE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerTemplate {

    // TODO inject services if the project uses them
    // private final ShopService shopService;
    //
    // public ControllerTemplate(ShopService shopService) {
    //     this.shopService = shopService;
    // }

    @GetMapping("/products")
    public String showProducts(Model model) {
        // TODO: model.addAttribute("products", shopService.getAllBooks());
        return "products";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("id") String id,
                            RedirectAttributes ra) {
        try {
            // TODO: find product by id and add to cart
            // ra.addFlashAttribute("success", "Added to cart.");
        } catch (Exception ex) {
            ra.addFlashAttribute("error", "Could not add to cart.");
        }
        return "redirect:/products";
    }

    @GetMapping("/shoppingCart")
    public String showShoppingCart(Model model) {
        // TODO: model.addAttribute("shoppingCart", cart);
        return "shoppingCart";
    }

    @PostMapping("/shoppingCart/delete")
    public String deleteFromCart(@RequestParam("id") String id,
                                 RedirectAttributes ra) {
        try {
            // TODO: remove item from cart
            // ra.addFlashAttribute("success", "Removed from cart.");
        } catch (Exception ex) {
            ra.addFlashAttribute("error", "Could not remove item.");
        }
        return "redirect:/shoppingCart";
    }

    @GetMapping("/bookDetails")
    public String showBookDetails(@RequestParam("id") String id,
                                 @RequestParam(value = "from", required = false) String from,
                                 Model model) {
        // TODO: Book book = shopService.getBook(id);
        // model.addAttribute("book", book);

        String backTarget = (from != null && from.equals("cart")) ? "/shoppingCart" : "/products";
        String backLabel  = (from != null && from.equals("cart")) ? "Back to shopping cart" : "Back to product list";

        model.addAttribute("from", from);
        model.addAttribute("backTarget", backTarget);
        model.addAttribute("backLabel", backLabel);
        return "bookDetails";
    }

    @PostMapping("/bookDetails/back")
    public String backFromDetails(@RequestParam(value = "from", required = false) String from) {
        return (from != null && from.equals("cart")) ? "redirect:/shoppingCart" : "redirect:/products";
    }
}
