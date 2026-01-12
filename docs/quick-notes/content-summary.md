# Web Applications — Content Summary

This document summarizes the **technical content** covered in the Web Applications lecture.
It describes **what is used**, **where**, and **for what purpose**, without exam strategy or workflow guidance.

---

## 1) JavaServer Faces (JSF)

### 1.1 JSF Pages (XHTML)
- XHTML pages under `src/main/webapp`
- XML namespaces:
  - `jakarta.faces.html`
  - `jakarta.faces.core`
  - PrimeFaces namespace (if used)
- Common components:
  - `h:form`
  - `h:outputText`
  - `p:inputText`
  - `p:commandButton`
  - `p:commandLink`
  - `p:dataTable`
  - `p:messages`

---

### 1.2 Managed Beans
- Java classes annotated with `@Named`
- Scope annotations:
  - `@RequestScoped`
  - `@ViewScoped`
  - `@SessionScoped`
- Beans may store:
  - form data
  - search criteria
  - selected objects
  - shopping cart state
- Beans using `ViewScoped` or `SessionScoped` must implement `Serializable`

---

### 1.3 Data Binding (EL)
- Expression Language (EL):
  - `#{bean.property}`
  - `#{bean.method}`
- Requires:
  - public getters/setters
  - matching property names
- Used for:
  - input values
  - table rendering
  - action calls

---

### 1.4 User Actions
- Actions triggered by:
  - `p:commandButton`
  - `p:commandLink`
- Action methods:
  - `public void method()`
  - `public String method()`
- Actions may:
  - modify bean state
  - call services
  - navigate to another page

---

### 1.5 Validation
- Validation mainly defined in XHTML
- Common validators:
  - `required="true"`
  - `f:validateLength`
  - `f:validateRegex`
  - `f:validateDoubleRange`
- Validation messages displayed using:
  - `p:messages`
  - `p:message`

---

### 1.6 Navigation
- Navigation via:
  - return strings from action methods
  - optional `faces-redirect=true`
- Details navigation:
  - selected object stored in bean
- Back navigation implemented explicitly

---

### 1.7 Lists and Tables
- Lists rendered using:
  - `p:dataTable`
- Attributes:
  - `value` → list
  - `var` → iteration variable
- Table rows may contain:
  - output fields
  - action links (details, remove, add)

---

### 1.8 Shopping Cart (JSF)
- Shopping cart stored in session-scoped bean
- Cart contains:
  - items
  - quantities
- Operations:
  - add item
  - remove item
  - list items

---

## 2) Spring MVC

### 2.1 Controllers
- Java classes annotated with `@Controller`
- Located under `src/main/java`
- Controller methods handle:
  - page rendering
  - request parameters
  - navigation

---

### 2.2 Request Mappings
- HTTP method mappings:
  - `@GetMapping`
  - `@PostMapping`
- URL paths must match template forms and links
- Parameters read using:
  - `@RequestParam`

---

### 2.3 Model Data
- Data passed to views using:
  - `Model`
  - `ModelMap`
- Attributes accessed in templates by name

---

### 2.4 FreeMarker Templates (.ftlh)
- Located under `src/main/resources/templates`
- Output expressions:
  - `${variable}`
- Lists:
  - `<#list items as item>`
- Templates may contain:
  - tables
  - forms
  - buttons
- Template names returned by controller without file extension

---

### 2.5 Forms and Actions
- HTML forms:
  - `method="get"` or `method="post"`
- Buttons submit identifiers (e.g., id, isbn)
- POST requests usually redirect after execution

---

### 2.6 Redirect and Flash Messages
- Redirect after POST:
  - `return "redirect:/path"`
- Temporary messages passed using:
  - `RedirectAttributes`

---

### 2.7 Details Page
- Details loaded by:
  - request parameter (id)
- Data retrieved from service
- Template displays all object fields
- Back navigation depends on request origin

---

### 2.8 Shopping Cart (Spring MVC)
- Shopping cart stored in session or controller-managed state
- Operations:
  - add item
  - remove item
  - list items
- Cart data passed to templates via model

---

## 3) Shared Concepts

### 3.1 Maven Projects
- Predefined Maven structure
- Compilation via:
  - `mvn test`
  - `mvn compile`

---

### 3.2 Services
- Business logic provided by existing services
- Controllers and beans call services
- Services return domain objects (Book, Author, etc.)

---

### 3.3 Domain Objects
- Typical domain objects:
  - Book
  - Author
  - ShoppingCart
- Fields include:
  - title
  - authors
  - ISBN
  - price
  - language
  - quantity

---

## 4) Technologies Used
- Java
- Maven
- JavaServer Faces (JSF)
- PrimeFaces (JSF UI components)
- Spring MVC
- FreeMarker
