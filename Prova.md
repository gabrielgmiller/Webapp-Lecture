# GUIA DE EXECUÇÃO DA PROVA – WebApp Lecture (JSF / Spring MVC)

Este guia descreve **o que fazer em cada questão (task)** da prova prática,
seguindo exatamente o padrão cobrado pelo professor.

A prova avalia:
- implementação prática
- funcionamento correto
- **compilação sem erros** (critério mais importante)

---

## REGRA GERAL DA PROVA (ANTES DE COMEÇAR)

1. O projeto Maven já vem pronto.
2. A correção **para no primeiro erro de compilação por método**.
3. Solução simples > solução bonita.
4. Sempre implemente primeiro o **happy path** (caminho feliz).
5. Compile várias vezes durante a prova.

---

## PASSO 0 — O que fazer ao abrir o projeto (2 minutos)

1. Abrir o projeto no IDE
2. Rodar:
   - `mvn test` **ou**
   - `mvn package`
3. Confirmar que:
   - o projeto compila
   - você sabe onde ficam:
     - Controllers / Beans
     - Templates / Pages

❗ Se não compilar no início, **corrija antes de começar qualquer task**.

---

## ESTRUTURA PADRÃO DE UMA QUESTÃO (TASK)

Toda questão segue alguma variação deste fluxo:

**Formulário → Submissão → Lógica → Validação → Lista → Detalhes**

---

# COMO RESOLVER CADA QUESTÃO (PASSO A PASSO)

## PASSO 1 — Criar o formulário (Form)

### Spring MVC
- Criar método `@GetMapping`
- Retornar a página do formulário
- Adicionar objeto `form` ao `Model`

### JSF
- Criar página `.xhtml`
- Usar `<h:form>`
- Inputs ligados ao managed bean (`#{bean.campo}`)

👉 **Objetivo:** conseguir abrir a tela do formulário sem erro.

---

## PASSO 2 — Receber os dados e chamar a lógica

### Spring MVC
- Criar método `@PostMapping`
- Receber o objeto do formulário com `@ModelAttribute`
- Chamar o método da lógica/service

### JSF
- Criar método `submit()` no managed bean
- Chamar a lógica dentro desse método
- Retornar o outcome (ou `null`)

👉 **Objetivo:** dados fluem do form para o backend.

---

## PASSO 3 — Implementar o caminho feliz (SEM validação ainda)

- Executar a lógica
- Gerar resultado
- Mostrar lista ou página seguinte

❗ **Não valide ainda**
❗ **Não complique**

👉 **Objetivo:** tudo funcionar sem erro de compilação.

🔁 Compile aqui:
- `mvn test` ou `mvn package`

---

## PASSO 4 — Mostrar lista de resultados

### Spring MVC
- `model.addAttribute("results", lista)`
- Criar template com loop (`<#list>`)

### JSF
- `<h:dataTable value="#{bean.results}" var="it">`
- Exibir campos básicos
- Criar link/ação para detalhes

👉 **Objetivo:** lista aparece corretamente.

🔁 Compile novamente.

---

## PASSO 5 — Página de detalhes

### Spring MVC
- Criar método `@GetMapping("/{id}")`
- Buscar item pelo `id`
- Passar para o `Model`
- Criar template `details.ftl`

### JSF
- Criar action ou link no datatable
- Definir `selected`
- Criar página `details.xhtml`

👉 **Objetivo:** conseguir abrir o detalhe de um item da lista.

🔁 Compile novamente.

---

## PASSO 6 — Validação (SÓ AGORA)

### Spring MVC
- Usar `@Valid` no formulário
- **`BindingResult` deve vir IMEDIATAMENTE após**
- Se houver erro:
  - retornar o formulário

### JSF
- Usar:
  - `required="true"`
  - validators
  - ou validação manual no bean com `FacesMessage`

👉 **Objetivo:** impedir dados inválidos e mostrar mensagens.

🔁 Compile novamente.

---

## PASSO 7 — Conferência final da questão

Antes de passar para a próxima task, verifique:

### Spring MVC
- `BindingResult` está na posição correta
- Nome do template bate com o arquivo
- Atributos do model batem com o template

### JSF
- `@Named("bean")` bate com `#{bean}`
- getters/setters existem
- nome da página no outcome está correto

🔁 Compile **uma última vez**.

---

# ESTRATÉGIA DE TEMPO (120 minutos)

- Task 1: ~25 minutos
- Task 2: ~25 minutos
- Task 3: ~30 minutos
- Task 4: ~30 minutos
- Últimos 10 minutos: build final + revisão

---

## REGRA DE OURO DA PROVA

> **Código que compila vale mais do que código bonito.**

Se algo der errado:
- volte para a última versão que compilava
- simplifique
- entregue o básico funcionando

---

## CHECKLIST MENTAL FINAL

Se eu receber uma task agora, eu sei:
- onde criar o formulário
- onde receber os dados
- onde chamar a lógica
- como mostrar lista
- como abrir detalhes
- como validar sem quebrar a compilação

Se a resposta for **sim**, você está pronto.
