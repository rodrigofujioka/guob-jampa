# AGENTS.md

## Project snapshot
- Stack: Spring Boot `4.1.0` + Java `21` + Maven Wrapper (`pom.xml`).
- Packaging baseline is a single Spring Boot app (`src/main/java/br/edu/iesp/guobjampa/GuobJampaApplication.java`).
- Current repo state: scaffold + a small working example of business layers for a "tarefa" (task) feature is implemented. See `controller/TarefaController.java`, `service/impl/TarefaServiceImpl.java`, `repository/InMemoryTarefaRepository.java`, `model/Tarefa.java`, and DTOs under `dto/`.

## Architecture and boundaries (current)
- Root package: `br.edu.iesp.guobjampa`.
- Planned layered structure already exists:
  - `controller/` (HTTP boundary)
  - `service/` (business logic)
  - `model/` (domain/persistence models)
  - `dto/` (API payload contracts)
- Data flow to follow this package order when adding features: controller -> service -> model, with DTOs at API boundaries.
- Runtime config currently comes from `src/main/resources/application.properties` (`spring.application.name=guob-jampa`).

## Build, run, and test workflows
- Windows build:
```powershell
.\mvnw.cmd clean compile
```
- Windows run:
```powershell
.\mvnw.cmd spring-boot:run
```
- Windows tests:
```powershell
.\mvnw.cmd test
```
- Equivalent cross-platform commands use `./mvnw`.
- Existing test pattern is full Spring context loading via `@SpringBootTest` (`src/test/java/br/edu/iesp/guobjampa/GuobJampaApplicationTests.java`).

## Project-specific conventions to preserve
- Keep new code under `br.edu.iesp.guobjampa...` package namespace.
- Use Spring MVC stack (`spring-boot-starter-webmvc`), not reactive APIs.
- Lombok is enabled and annotation processing is explicitly configured in `maven-compiler-plugin`; keep Lombok-based models/DTOs compatible with compile and test-compile phases.
- `spring-boot-maven-plugin` excludes Lombok from final artifact; do not treat Lombok as a runtime dependency.

## Integration/documentation points
- OpenAPI UI dependency is present: `org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.3`.
- Spec placeholders exist but are empty:
  - `src/main/resources/specs/api/tarefas-openapi.yaml` (example API spec for the tarefa endpoints)
  - `src/main/resources/specs/negocio/produtos-negocio-parte1.md`
  - `src/main/resources/specs/negocio/produtos-negocio-parte2.md`
- No external systems (DB, queues, third-party APIs) are configured yet in repo-tracked files.

## AI-instructions sources searched
- One glob search was run for AI/convention files:
  - `**/{.github/copilot-instructions.md,AGENT.md,AGENTS.md,CLAUDE.md,.cursorrules,.windsurfrules,.clinerules,.cursor/rules/**,.windsurf/rules/**,.clinerules/**,README.md}`
- Result at generation time: no matching files found.

