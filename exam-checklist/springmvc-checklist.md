# Spring MVC Exam Checklist (Web Applications)

This checklist is designed for **exam-style Spring MVC tasks** using **FreeMarker (.ftlh)** templates in a prepared Maven project.

---

## 0) Before You Start (2 minutes)
- Run:
  - `mvn test` (or the project’s compile/test command)
- Locate:
  - `src/main/java/.../controller/` (controllers)
  - `src/main/resources/templates/` (FreeMarker views)
  - `src/main/resources/static/` (CSS/JS if present)
- Find an existing controller method and copy its mapping style.

---

## 1) FreeMarker Page Basics (.ftlh)
Checklist:
- [ ] Template file is placed in `src/main/resources/templates/`
- [ ] Correct layout usage (if there is a `template.ftlh` / layout macro)
- [ ] Use `${...}` to print values
- [ ] Use `<#list ... as ...>` for lists
- [ ] Buttons/forms point to the correct route (`action="..."`)

---

## 2) Controller Mappings (Core Pattern)
You will usually implement:
- `@GetMapping` to **show a page**
- `@PostMapping` to **handle a button/form submit**
- `Model` / `ModelMap` / `RedirectAttributes` to pass data/messages

Checklist:
- [ ] Method annotations match the required HTTP method
- [ ] URL paths match the template links/forms
- [ ] Method returns the **view name** (template name without extension)
  - Example: return `"products"` for `products.ftlh`

---

## 3) Show List of Products (products.ftlh)
Typical exam requirements:
- Show all products (title + first author)
- Add buttons per row (add to cart / show details)

Template checklist:
- [ ] `<#list products as p>` loop exists
- [ ] Print fields: `${p.title}` and `${p.firstAuthor}` (or project-specific getters)
- [ ] Each row has buttons:
  - Add to cart
  - Show details

Controller checklist:
- [ ] `@GetMapping("/products")` loads the products list
- [ ] Adds list to model: `model.addAttribute("products", products)`
- [ ] Returns `"products"`

---

## 4) Add to Cart (POST from products page)
Common exam pattern:
- Each product row has a button with an ID (e.g., isbn / id)
- Controller receives that ID and updates the shopping cart

Template checklist:
- [ ] Button submits an identifier:
  - hidden input: `<input type="hidden" name="id" value="${p.id}">`
  - or button value: `<button name="action" value="add:${p.id}">Add</button>`
- [ ] Form method is POST

Controller checklist:
- [ ] `@PostMapping("/addToCart")` (or project path) exists
- [ ] Reads parameter with `@RequestParam`
- [ ] Finds product by ID using service/repository
- [ ] Adds item to cart (cart stored in session/model depending on project)
- [ ] Redirects back to products (PRG pattern):
  - `return "redirect:/products";`

---

## 5) Shopping Cart View (shoppingCart.ftlh)
Typical requirements:
- Show title, first author, quantity for each cart item
- Add buttons per row:
  - show details
  - delete item

Template checklist:
- [ ] `<#list shoppingCart.items as item>` (project-specific name)
- [ ] Print: author, title, quantity
- [ ] Buttons for:
  - Details
  - Delete

Controller checklist:
- [ ] `@GetMapping("/shoppingCart")` loads cart and returns `"shoppingCart"`
- [ ] `model.addAttribute("shoppingCart", cart)` if needed

---

## 6) Details Page (bookDetails.ftlh)
Typical requirements:
- Show all available data of a book
- Back button:
  - back to product list OR back to shopping cart depending on where details was called from

Template checklist:
- [ ] Displays all relevant fields of the book (`${book...}`)
- [ ] Back button exists and posts/links to the correct route
- [ ] Back label changes depending on origin:
  - "Back to shopping cart"
  - "Back to product list"

Controller checklist:
- [ ] `@GetMapping("/bookDetails")` loads details by ID
- [ ] Stores origin (e.g., `from=cart` or `from=products`)
- [ ] Adds:
  - `book`
  - `from` (or `backTarget`)
  - `backLabel`
- [ ] `@PostMapping("/bookDetails/back")` routes correctly based on origin

---

## 7) Delete Item From Cart
Template checklist:
- [ ] Delete button submits the correct ID
- [ ] Uses POST (recommended)

Controller checklist:
- [ ] `@PostMapping("/shoppingCart/delete")` exists
- [ ] Reads `@RequestParam("id")`
- [ ] Removes item from cart
- [ ] Redirects back to `/shoppingCart`

---

## 8) Validation (If Required)
Sometimes tasks include simple validation.

Checklist:
- [ ] Validate required parameters (null/empty)
- [ ] If invalid, set a user-friendly message and redirect back
- [ ] Avoid crashes (null-safe)

---

## 9) Messages (Success / Error)
Checklist:
- [ ] Use `RedirectAttributes` for flash messages when redirecting
- [ ] Display message in templates (if a messages section exists)

---

## 10) Compile-Error Killers (Top Mistakes)
Checklist:
- [ ] Mapping path mismatch between template and controller
- [ ] Returning wrong view name (must match `.ftlh` filename)
- [ ] Missing `@RequestParam` or wrong parameter name
- [ ] Null pointer due to missing cart initialization
- [ ] Using GET for destructive actions (delete) when project expects POST
- [ ] Wrong package/import for controller annotations

---

## 11) Final Submission Check (Last 5 minutes)
- [ ] `mvn test` passes (or at least compiles)
- [ ] Click flow:
  - products → add to cart → shopping cart
  - details from products
  - details from cart
  - back button label and destination correct
  - delete works
- [ ] Save all files to the required exam directory

---
