# JSF Exam Checklist (Web Applications)

This checklist is designed for **exam-style JSF tasks**: implement small features in a prepared Maven project with **minimal code** and **zero compile errors**.

---

## 0) Before You Start (2 minutes)
- Open the Maven project and run:
  - `mvn -q test` or `mvn test` (or whatever the project uses)
  - Fix **compile errors first** (evaluation stops at the first compile error).
- Locate:
  - `src/main/webapp/` (XHTML pages)
  - `src/main/java/` (beans/services)
  - Existing navigation patterns (how pages are referenced)

---

## 1) Create a Page (XHTML Skeleton)
**Typical file:** `something.xhtml`

Minimal structure you will usually need:
- A template include (if the project uses templates)
- A `h:form` for inputs/actions
- A `p:messages` area for feedback

Checklist:
- [ ] Correct XML namespaces used (copy from an existing page in the project)
- [ ] Page title/header added
- [ ] `h:form` present when you submit data
- [ ] `p:messages` present to show validation/service errors

---

## 2) Create/Use a Managed Bean
**Goal:** bind form fields + implement action methods.

Checklist:
- [ ] Bean exists under `src/main/java/...`
- [ ] Bean has the correct annotations (depends on project setup):
  - [ ] `@Named("beanName")` (or no explicit name if default is used)
  - [ ] Correct scope:
    - `@SessionScoped` for shopping cart / cross-page state
    - `@ViewScoped` for page state (filters, selected item)
    - `@RequestScoped` for simple stateless actions
- [ ] Bean implements `Serializable` if required by the scope (`ViewScoped`/`SessionScoped`)
- [ ] All properties have proper getters/setters (EL needs them)
- [ ] Action methods are `public` and return correct navigation outcome:
  - `String` outcome (e.g., `"shoppingCart?faces-redirect=true"`)
  - or `void` if staying on the same page (common with AJAX)

---

## 3) Bind Form Fields (Read Data from Form)
**Pattern:** `value="#{bean.property}"`

Checklist:
- [ ] Each input component has `id` and `value`
- [ ] The bean property exists and has getter/setter
- [ ] Number fields use number-capable components if available (or validate)
- [ ] Date fields use the correct date component/type used in the project

Common components:
- `p:inputText`
- `p:inputNumber`
- `p:datePicker` (if included) or project-specific date input

---

## 4) Execute Application Logic (Action / Listener)
**Pattern:** buttons/links calling bean methods.

### Command button (submit form)
- `p:commandButton value="Save" action="#{bean.save}"`

Checklist:
- [ ] Action method exists: `public String save()` or `public void save()`
- [ ] If the method calls a service (e.g., `ShopService`), handle exceptions
- [ ] Add success/error messages (see section 8)

### Command link (row actions)
- `p:commandLink value="Remove" action="#{cartBean.remove(item)}" update="tableId"`

Checklist:
- [ ] Method signature matches the call
- [ ] When passing objects, use the same variable name as in the table (`var`)
- [ ] Update the right component IDs if AJAX is used

---

## 5) Show a List of Results (DataTable)
**Pattern:** `p:dataTable`

Minimal example pattern:
- `value="#{bean.items}" var="item"`

Checklist:
- [ ] List getter exists and returns a `List<...>`
- [ ] `var` name matches the EL usage inside columns
- [ ] Each column shows correct fields:
  - title, first author, quantity (typical Shop24 exercises)
- [ ] Add row action controls:
  - Add known patterns: add to cart, remove, show details

---

## 6) Show Details Page (Navigation + Selected Item)
There are two common exam patterns:

### A) Store “selected” in a View/Session bean
- Click “Details” sets `bean.selected = item`
- Navigate to `detailsView.xhtml`

Checklist:
- [ ] `public String showDetails(Type item)` sets `selected`
- [ ] Details page reads `#{bean.selected.field}`
- [ ] Provide a “Back” link to list/cart

### B) Pass an ID parameter and reload from service
- Click “Details” passes `id` (or `isbn`)
- Details bean loads object via service

Checklist:
- [ ] CommandLink includes parameter (`f:param`) if project uses it
- [ ] Bean reads parameter on load (project-specific approach)
- [ ] Null-safe handling if ID not found

---

## 7) Shopping Cart Pattern (SessionScoped)
Typical exercises require:
- Shopping cart stored in session
- Items list with quantity
- Add/remove operations

Checklist:
- [ ] `ShoppingCartBean` is `@SessionScoped`
- [ ] Uses `ShoppingCart` class provided by the project
- [ ] Methods exist:
  - `addToCart(book)` (calls `shoppingCart.addItem(book)`)
  - `removeFromCart(book)` (calls `shoppingCart.removeItem(book)` or similar)
- [ ] Shopping cart page shows:
  - first author, title, quantity

---

## 8) Validation (Must-Have)
Validation is often done in XHTML using:
- required constraints
- regex/pattern constraints
- min length constraints

Checklist:
- [ ] Required fields use `required="true"` and a message
- [ ] Length constraints exist (e.g., first/last name ≥ 2)
- [ ] ISBN pattern constraint (digits and `-` only) if asked
- [ ] Price validation (must be positive)
- [ ] Authors list must contain at least one author (if asked)
- [ ] Validation messages are visible (page has `p:messages`)

**Rule:** If validation fails, you must show a suitable message.

---

## 9) Messages (Success / Error Feedback)
Use Faces Messages (project-specific pattern may exist).

Checklist:
- [ ] On success: show a success message
- [ ] On exception: show an error message with a short reason
- [ ] Messages are displayed in `p:messages`

---

## 10) AJAX (Only When Needed)
Many projects use PrimeFaces AJAX (`p:ajax`) to update parts of the page.

Checklist:
- [ ] Use `process` to limit what is sent
- [ ] Use `update` to refresh the right area (table/messages/panels)
- [ ] Verify component IDs (often `formId:componentId`)

Common pattern:
- [ ] `process="@this someFieldId"`
- [ ] `update="tableId messagesId"`

---

## 11) Scopes Cheat Sheet (Exam-Ready)
- **@SessionScoped**: shopping cart, user session state, cross-page state
- **@ViewScoped**: filters/search criteria, selected item for details, page-local state
- **@RequestScoped**: small stateless actions (less common for multi-step pages)

---

## 12) Compile-Error Killers (Top Mistakes)
These are the errors that cost the most because evaluation stops early:

Checklist:
- [ ] Missing import or wrong package name in bean
- [ ] Bean method name mismatch vs XHTML EL call
- [ ] Wrong return type for action method (if navigation expected)
- [ ] Bean not `Serializable` for View/Session scope
- [ ] Getter/Setter missing → EL fails at runtime (still avoid)
- [ ] Wrong component ID in `update`/`process` (AJAX appears “broken”)
- [ ] Null pointer due to uninitialized lists/objects:
  - Initialize lists in constructor or `@PostConstruct`
- [ ] Typos in XHTML namespace prefixes

---

## 13) Final Submission Check (Last 5 minutes)
- [ ] Run `mvn test` (or the project’s compile command)
- [ ] Click through: list page → add/remove → details → back navigation
- [ ] Ensure validation triggers correctly
- [ ] Ensure messages display for success and failure
- [ ] Save everything to the required directory (exam rule)

---
