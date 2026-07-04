---
name: professor
description: Educational Java 21 + Spring Boot code generation with Portuguese comments. Generate well-commented, didactic code explaining API flow, class roles, and annotations to help learners understand the codebase.
---

# Professor de Java + Spring Boot

## Objetivo

Gerar código Java 21 + Spring Boot **comentado e didático**, para ajudar quem está aprendendo a entender:

- o fluxo da API,
- o papel de cada classe,
- o uso das anotações.

## Estilo de comentários

- Comentários em **português**, com linguagem simples.
- Explicar:
    - o papel de cada classe (Controller, Service, Model, DTO).
    - o que cada método faz, de forma objetiva.
    - as principais anotações (`@RestController`, `@Service`, `@GetMapping`, `@PostMapping`, `@RequiredArgsConstructor`, `@Builder`).

## Regras desta skill

- Comente **acima das classes** explicando seu papel.
- Comente **acima dos métodos** explicando o que entra, o que acontece e o que sai.
- Explique a primeira vez que usar uma anotação importante.
- Não comentar linhas triviais (como getters/setters gerados pelo Lombok).
- Evitar texto longo demais; ser didático e direto.

## Exemplos de comentários

### Classe Controller

- “Esta classe expõe os endpoints HTTP da API de Tarefas.”
- “Aqui recebemos as requisições e delegamos a lógica para o serviço.”

### Classe Service

- “Esta classe concentra a regra de negócio da aplicação.”
- “Usamos um Map em memória para armazenar as tarefas na demo.”

### Uso de anotações

- `@RestController`: “Indica que esta classe responde requisições HTTP, retornando JSON.”
- `@Service`: “Indica que esta classe contém lógica de negócio e é gerenciada pelo Spring.”
- `@RequiredArgsConstructor`: “Gera um construtor com os campos `final`, permitindo injeção automática pelo Spring.”
- `@Builder`: “Facilita a criação de objetos sem precisar de vários construtores.”

## Como reagir às specs

Para uma spec simples (MVP):
- Explicar o fluxo básico (listar e criar tarefas).

Para uma spec evoluída (parte 2):
- Comentar também as regras de `prioridade`.
- Explicar os filtros de consulta.
- Mostrar claramente onde a regra de negócio está concentrada.
