Perfeito — foi só corte de mensagem, nada errado do seu lado 👍
Aqui vai o ARQUIVO COMPLETO do Spring MVC Task Template, pronto para copiar e colar inteiro.

👉 Substitua todo o conteúdo do
exam-checklist/springmvc-task-template.md
por isso abaixo.

⸻


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

  private __________;
  private __________;

  public __________ get__________() {
    return __________;
  }

  public void set__________(__________ value) {
    this.__________ = value;
  }

}


⸻

4) Controller skeleton (copy-ready)

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/__________")
public class __________Controller {

  private final __________Service service;

  public __________Controller(__________Service service) {
    this.service = service;
  }

  @GetMapping
  public String showForm(Model model) {
    model.addAttribute("form", new __________Form());
    return "__________"; // form.ftl
  }

  @PostMapping
  public String submit(
      @ModelAttribute("form") @Valid __________Form form,
      BindingResult br,
      Model model
  ) {

    // 1) validation errors -> return form
    if (br.hasErrors()) {
      return "__________"; // form.ftl
    }

    // 2) happy path -> call logic
    var results = service.__________(form);

    // 3) show list
    model.addAttribute("results", results);
    return "__________"; // list.ftl
  }

  @GetMapping("/{id}")
  public String details(@PathVariable("id") Long id, Model model) {
    var item = service.__________ById(id);
    model.addAttribute("item", item);
    return "__________"; // details.ftl
  }
}


⸻

5) Validation (minimal patterns)

@NotNull
private Integer __________;

@NotBlank
private String __________;

@Min(0)
private Integer __________;


⸻

6) Templates (minimum checklist)

Form — form.ftl
	•	<form method="post" action="/__________">
	•	Inputs must bind to: form.fieldName
	•	Display field errors
	•	Display global errors (optional)

List — list.ftl
	•	Iterate results
	•	Each row links to details:
	•	/__________/${item.id}

Details — details.ftl
	•	Read from item.field

⸻

7) Compile-safe checklist (MANDATORY)
	•	BindingResult comes immediately after the @Valid parameter
	•	Template names match exactly:
	•	return "form" → form.ftl
	•	Attribute names are consistent:
	•	form, results, item
	•	All service methods exist and compile
	•	No unused imports

⸻

8) End-of-task command
	•	mvn -q test or mvn -q package

---


Quando confirmar que **esse arquivo está ok**, seguimos para o **JSF Task Template (finalizar Passo 2)** ou já partimos direto pro **Passo 3 (Snippets atômicos)** — você escolhe.
