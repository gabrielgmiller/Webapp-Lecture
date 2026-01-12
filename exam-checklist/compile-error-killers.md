# Compile-Error Killers (JSF + Spring MVC)

This file lists the most common mistakes that destroy exam points because evaluation stops early or the app flow breaks.

---

## 1) Universal Killers (Both Frameworks)
- [ ] **Project does not compile** (`mvn test` / `mvn compile` fails)
- [ ] Typos in method names used by the UI (button/link calls a method that does not exist)
- [ ] Wrong package/import after moving/creating files
- [ ] NullPointerException due to uninitialized objects/lists
  - Always initialize lists (constructor or `@PostConstruct`)
- [ ] Wrong file location (template/page not in the correct folder)

---

## 2) JSF Killers
### Bean + EL binding
- [ ] Bean property exists but **no getter/setter**
- [ ] Bean method signature mismatch:
  - UI calls `remove(book)` but method expects different type/params
- [ ] Wrong scope for required state:
  - Shopping cart must survive navigation → `@SessionScoped`
- [ ] `@ViewScoped` / `@SessionScoped` bean not `Serializable`

### XHTML issues
- [ ] Wrong XML namespaces (copy from a working page)
- [ ] Component IDs in `update`/`process` are wrong (AJAX appears broken)
- [ ] Missing `<h:form>` around inputs/buttons
- [ ] Missing messages component:
  - No `p:messages` → user never sees validation/service errors

### Navigation / details
- [ ] Details page reads `selected` but `selected` is never set
- [ ] Back link returns wrong outcome or wrong page path

---

## 3) Spring MVC + FreeMarker Killers
### Controller mappings
- [ ] Template form/link points to `/x`, but controller listens on `/y`
- [ ] Wrong HTTP method:
  - Template submits POST, controller has only `@GetMapping`
- [ ] Returning wrong view name:
  - Must match template filename (without `.ftlh`)

### Request parameters
- [ ] Parameter name mismatch:
  - `<input name="id">` but controller expects `@RequestParam("bookId")`
- [ ] Missing `@RequestParam` (parameter becomes null)
- [ ] Parsing errors:
  - `Long.parseLong(...)` on empty string → validate before parsing

### Cart state
- [ ] Cart not initialized (first add fails)
- [ ] Delete modifies cart but redirect goes to wrong page

### FreeMarker template issues
- [ ] Using the wrong variable name:
  - Controller adds `products`, template uses `productList`
- [ ] Missing `<#list ...>` loop or wrong `as` variable usage

---

## 4) 5-Minute Final Check (Exam Safety)
Run:
- [ ] `mvn test` (or project compile command)

Click through flow:
- [ ] List page loads (no error)
- [ ] Add to cart works
- [ ] Shopping cart page loads
- [ ] Details page loads (from list and from cart if required)
- [ ] Back button goes to correct page
- [ ] Delete/remove works
- [ ] Validation triggers and message is visible

---

## 5) Exam Rule Reminder
> Keep it simple. Make it compile. Only then improve.

---
