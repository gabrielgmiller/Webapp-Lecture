# Spring MVC — Task Template (Form → Validate → List → Details)

Use this as a copy/paste recipe. Implement the happy path first, then add validation.

---

## 0) Identify (30s)
- Project: ______________________
- Task name: ____________________
- Entities involved: _____________
- Input fields: _________________
- Output: list / details / both: __

---

## 1) Files to touch (check paths)
- Controller: `src/main/java/.../controller/_________________.java`
- Logic/Service: `src/main/java/.../(service|logic)/_________________.java`
- Templates: `src/main/resources/templates/`
  - Form: `__________.ftl`
  - List: `__________.ftl`
  - Details: `__________.ftl`

---

## 2) Routes (define first)
- GET form page: `GET  /__________`
- POST submit:   `POST /__________`
- GET list:      `GET  /__________`
- GET details:   `GET  /__________/{id}` (or `?id=...`)

---

## 3) DTO / Form object (if needed)
Create a minimal form model if binding multiple fields:

```java
public class __________Form {
  // fields
  private __________;
  private __________;

  // getters/setters
}
