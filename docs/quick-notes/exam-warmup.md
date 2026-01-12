# Exam Warmup — Web Applications (JSF + Spring MVC)

This warmup simulates the **real exam conditions**:
- 4 tasks
- ~30 minutes per task
- focus on patterns, not perfection

Goal: finish everything compiling and working.

---

## Global Rules (same as exam)
- Do NOT over-engineer
- Use snippets and checklists
- Fix compile errors immediately
- Prefer working code over clean code

---

## Task 1 — JSF (List + Action)
⏱ Time limit: **30 minutes**

### Scenario
Create or complete a JSF page that:
1) Shows a list of products (title + first author)
2) Allows adding a product to the shopping cart

### Required flow
- Page loads without error
- Clicking “Add” updates the shopping cart
- No navigation required

### Files to touch
- `products.xhtml`
- `ProductBean.java`
- `ShoppingCartBean.java`

### Checklist to use
- `exam-checklist/jsf-checklist.md`
- JSF snippets: datatable + managed bean

### Done when
- List renders
- Button works
- `mvn test` compiles

---

## Task 2 — JSF (Details + Remove)
⏱ Time limit: **30 minutes**

### Scenario
Extend the shopping cart:
1) Add a “Details” link per item
2) Add a “Remove” link per item
3) Confirm navigation back works

### Required flow
- From cart → details page
- Details page shows full data
- Back returns to cart
- Remove deletes item correctly

### Files to touch
- `shoppingCart.xhtml`
- `detailsView.xhtml`
- `ShoppingCartBean.java`

### Checklist to use
- `exam-checklist/jsf-checklist.md`
- Compile-error killers

### Done when
- No NullPointerExceptions
- Navigation works
- `mvn test` compiles

---

## Task 3 — Spring MVC (List + Cart)
⏱ Time limit: **30 minutes**

### Scenario
Create/complete a Spring MVC flow:
1) Show products list
2) Add product to shopping cart
3) Show shopping cart page

### Required flow
- `/products` loads
- POST adds item to cart
- `/shoppingCart` shows items

### Files to touch
- `ShopController.java`
- `products.ftlh`
- `shoppingCart.ftlh`

### Checklist to use
- `exam-checklist/springmvc-checklist.md`
- Spring snippets (controller + list)

### Done when
- Redirect works
- Cart updates
- No mapping errors

---

## Task 4 — Spring MVC (Details + Context Back)
⏱ Time limit: **30 minutes**

### Scenario
Add details navigation:
1) Details from products
2) Details from shopping cart
3) Back button label and target depend on origin

### Required flow
- Details shows correct data
- Back button text is correct
- Back target is correct

### Files to touch
- `ShopController.java`
- `bookDetails.ftlh`
- `products.ftlh`
- `shoppingCart.ftlh`

### Checklist to use
- `exam-checklist/springmvc-checklist.md`
- Compile-error killers

### Done when
- All flows work
- POST/GET mappings correct
- `mvn test` compiles

---

## Final Self-Check (10 minutes)
- [ ] No compile errors
- [ ] All pages load
- [ ] All buttons work
- [ ] Messages appear when needed
- [ ] No unnecessary refactoring

---

## Exam Mindset Reminder
> The exam rewards **correctness and completeness**, not elegance.

If it works and compiles, it is good enough.
