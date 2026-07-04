# Skill: Clean Code para Java + Spring Boot

## Objetivo

Gerar código Java 21 + Spring Boot **simples, legível e fácil de manter**, adequado para APIs REST pequenas e médias.

## Regras desta skill

- Use **nomes claros** para classes, métodos e variáveis.
- Mantenha **métodos pequenos**, com uma responsabilidade principal.
- Não coloque **regra de negócio** no Controller.
- Use `@RequiredArgsConstructor` para injeção de dependências.
- Use `@Builder` para construir objetos de resposta, quando fizer sentido.
- Separe bem:
    - `Controller` (entrada/saída HTTP)
    - `Service` (regra de negócio)
    - `Model` (interno)
    - `DTO` (Request/Response)
- Evite comentários óbvios, prefira código bem escrito.
- Evite abreviações em nomes.

## Padrão esperado

### Controller

- Mapeia o endpoint HTTP.
- Recebe `Request` e devolve `Response`.
- Chama o Service e não faz regra de negócio.

### Service

- Contém toda a regra de negócio.
- Usa um `Map` em memória para armazenar dados na demo.
- Tem métodos pequenos, como:
    - `listarTarefas()`
    - `criarTarefa(request)`
    - `filtrarPorPrioridade(...)`

### DTOs

- `Request` contém dados de entrada da API.
- `Response` contém dados de saída, prontos para serem devolvidos ao cliente.

## Como reagir a specs maiores

Quando a spec crescer (por exemplo, parte 2 com mais campos e filtros):

- Mantenha a separação clara entre camadas.
- Não crie estruturas desnecessárias (sem microservices, sem patterns complexos).
- Adicione apenas o que a spec pedir.
- Garanta que o código continue legível, mesmo com mais regras.
