# EXAM QUICKSTART (WebApp Lecture)

Goal: open a prepared Maven project, locate what matters, implement tasks fast, and avoid compile errors.

---

## 0) Zero-think commands (run these first)
From the project root:

- Build (fast):
  - `mvn -q test`
  - if needed: `mvn -q package`

If tests are slow or not present, still prefer `mvn -q package` as the final check.

---

## 1) Where to code (project map)

### A) Spring MVC (FreeMarker)
Typical structure:
- Controllers: `src/main/java/.../controller/`
- Services / Logic: `src/main/java/.../service/` or `src/main/java/.../logic/`
- Templates: `src/main/resources/templates/` (FreeMarker: `*.ftl`)
- Static: `src/main/resources/static/`

What you will usually touch:
- 1 Controller
- 1 Logic/Service class (or add a method)
- 1-2 templates (form + list/details)

### B) JSF
Typical structure:
- Pages: `src/main/webapp/*.xhtml` (or `src/main/webapp/WEB-INF/*.xhtml`)
- Beans: `src/main/java/.../beans/` (or `.../controller/`)

What you will usually touch:
- 1 Bean
- 1-2 pages (form + list/details)

---

## 2) Exam task flow (default pattern)
Most tasks are variations of:

1. Form page (inputs)
2. Submit action (calls logic)
3. Validation (reject invalid values)
4. List page (show results)
5. Details page (show one item)

Always implement the "happy path" first:
Form -> List -> Details
Then add validation.

---

## 3) Minimal checklist before editing code
- Identify: framework (Spring MVC vs JSF)
- Find: existing controller/bean and existing pages/templates
- Confirm: how routing/navigation works in this project
- Confirm: how the model is passed to the view (Spring: Model; JSF: bean fields)

---

## 4) End-of-task safety checks (do every task)
- `mvn -q test` or `mvn -q package`
- Ensure the route/page name matches exactly (case-sensitive)
- Ensure method signature matches what the view calls
- No unused imports / missing annotations

---

## 5) Time plan (120 min / 4 tasks)
Recommended pacing:
- Task 1: 25 min
- Task 2: 25 min
- Task 3: 30 min
- Task 4: 30 min
(Leave the last 10 min for a final clean build.)

---

## 6) If something breaks: fallback strategy
- Revert to the last compiling state
- Implement a simpler version (no extras)
- Rebuild immediately

Golden rule: compiling code > perfect solution.
