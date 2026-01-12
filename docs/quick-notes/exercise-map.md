# Exercise Map — What to Edit (Fast Navigation)

This file maps each exercise requirement to the exact files/classes you typically touch.
Goal: read the task → immediately know WHERE to work.

---

## JSF — Exercise 1 (Shop basics)
Source: Exercise 1 PDF.  [oai_citation:0‡Exercise1.pdf](sediment://file_00000000865c71f4ad37b1563e006e08)

### Tasks
1) Create `products.xhtml` + headline  
2) Show list of all products (title + first author)  
3) Add link to add product to cart  
4) Create `shoppingCart.xhtml` and show cart items (title, first author, quantity)

### Touch points
- `src/main/webapp/.../products.xhtml`
- `src/main/java/.../ProductBean.java`
  - Add getter for all books/products (calls `ShopService.searchBook(...)` or project equivalent)
- `src/main/java/.../ShoppingCartBean.java` (**Session scope**)
  - Store `ShoppingCart` object and implement `addToCart(Book book)`
- `src/main/webapp/.../shoppingCart.xhtml`
  - `p:dataTable` over cart items

---

## JSF — Exercise 2 (Details + Remove)
Source: Exercise 2 PDF.  [oai_citation:1‡Exercise2.pdf](sediment://file_000000007d5c71f4ab08987b31d9634c)

### Tasks
1) Create `detailsView.xhtml` (show all book data) + back link  
2) Add “Details” link per cart row  
3) Add “Remove” link per cart row  
4) Implement remove logic

### Touch points
- `src/main/webapp/.../detailsView.xhtml`
- `src/main/webapp/.../shoppingCart.xhtml` (add links)
- `src/main/java/.../ShoppingCartBean.java`
  - `showDetails(Book book)` → sets `selected` and navigates
  - `remove(Book book)` → calls `shoppingCart.removeItem(book)`

---

## JSF — Exercise 3 (Template + Forms + Search UI)
Source: Exercise 3 PDF.  [oai_citation:2‡Exercise3.pdf](sediment://file_00000000fa1471f48aa85b25a521eb52)

### Tasks
1) Create `template.xhtml` (menu row, content row, footer row)  
2) Use template in `index.xhtml`  
3) Create `addAuthor.xhtml` (form: first/last name) + menu entry  
4) Create `AuthorBean.java` with bound properties  
5) Apply template to all `webapp/` pages  
6) Update `addBook.xhtml` layout + fields (incl. number/date) + `BookBean` fields  
7) Add search form in `products.xhtml` (search mode + text + button) + adjust `ProductBean`

### Touch points
- `src/main/webapp/.../template.xhtml`
- All pages: add template usage
- `src/main/webapp/.../addAuthor.xhtml`
- `src/main/java/.../AuthorBean.java`
- `src/main/webapp/.../addBook.xhtml`
- `src/main/java/.../BookBean.java`
- `src/main/webapp/.../products.xhtml` (search row)
- `src/main/java/.../ProductBean.java` (search criteria fields + search action)

---

## JSF — Exercise 4 (Save + Validation + Search logic)
Source: Exercise 4 PDF.  [oai_citation:3‡Exercise4.pdf](sediment://file_00000000fddc71f4b9ae16b9f2757677)

### Tasks
1) Implement `AuthorBean.save()` using `ShopService.addAuthor`, show messages  
2) Validate author first/last name (min length 2)  
3) Implement `BookBean.save()` using `ShopService.addBook`, show messages  
4) Validate book fields:
   - required: title, ISBN, language, price
   - ISBN pattern: digits and "-"
   - price positive
   - authors list at least 1  
5) Implement `ProductBean.search()` using `ShopService.searchBook(...)`:
   - include author last name and/or title  
   - show error if no results

### Touch points
- `src/main/java/.../AuthorBean.java` → `save()`
- `src/main/webapp/.../addAuthor.xhtml` → validators + messages
- `src/main/java/.../BookBean.java` → `save()`
- `src/main/webapp/.../addBook.xhtml` → validators
- `src/main/java/.../ProductBean.java` → `search()` implementation
- `src/main/webapp/.../products.xhtml` → search button `action="#{productBean.search}"`

---

## Spring MVC — Exercise 5 (Template + Products + Cart)
Source: Exercise 5 PDF.  [oai_citation:4‡Exercise5.pdf](sediment://file_00000000a63071f48b9bd646bd379122)

### Tasks
1) Complete `template.ftlh` body: menu row + content row + copyright  
2) Complete `products.ftlh`: list products (title + first author) + add-to-cart button  
3) Implement controller methods:
   - show products page
   - add to cart (read button value/parameter)  
4) Create `shoppingCart.ftlh`: show author, title, quantity  
5) Implement controller method to show shopping cart

### Touch points
- `src/main/resources/templates/template.ftlh` (or `.flth` per project)
- `src/main/resources/templates/products.ftlh`
- `src/main/resources/templates/shoppingCart.ftlh`
- `src/main/java/.../controller/ShopController.java`

---

## Spring MVC — Exercise 6 (Details + Delete + Context-aware Back)
Source: Exercise 6 PDF.  [oai_citation:5‡Exercise6.pdf](sediment://file_00000000a03c71f49cdada8ae563f72c)

### Tasks
1) Add “Details” button in `products.ftlh`, modify `addToCart` to branch when details clicked  
2) Create `bookDetails.ftlh`: show full data + back button  
   - implement `GetMapping` for details and `PostMapping` for back  
3) Add buttons in `shoppingCart.ftlh`: details + delete; implement controller delete method  
4) Back button label depends on origin (from cart vs from products)

### Touch points
- `src/main/resources/templates/products.ftlh`
- `src/main/resources/templates/bookDetails.ftlh`
- `src/main/resources/templates/shoppingCart.ftlh`
- `src/main/java/.../controller/ShopController.java`
  - details GET
  - back POST
  - delete POST
  - origin handling (`from=cart|products`)

---

## Exam Reality Check (What the exam tests)
Official scope: 4 tasks, 2 Maven projects, similar to exercises, less code.  [oai_citation:6‡InformationExamination.pdf](sediment://file_000000007c8071f49b4490fc214e3031)

The core pattern in both frameworks:
**Form → Read input → Validation → List → Details**
