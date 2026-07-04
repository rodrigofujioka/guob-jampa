# Guob Jampa

> **Observação:** este repositório foi intencionalmente simplificado para a palestra **“Agentes com Skills e Guardrails: geração segura de código Java a partir de specs”**, apresentada em **04/07/2026**.  
> Mais informações sobre o evento em <a href="https://guob.com.br/joaopessoa/" target="_blank" style="text-decoration: underline;">https://guob.com.br/joaopessoa/</a>.  
> O foco aqui é **didático**, então estruturas, nomes e specs foram reduzidos para facilitar a demonstração ao vivo.

Projeto de demonstração de geração segura de código Java a partir de specs, usando agentes de IA, skills e guardrails.

## Objetivo

Este projeto foi montado para mostrar, de forma prática e didática, como usar:

- **Specs** para descrever o que deve ser construído;
- **Skills** para orientar o comportamento do agente;
- **Guardrails** para limitar o que o agente não pode fazer.

A ideia é gerar código Java 21 com Spring Boot de forma previsível, segura e fácil de manter.

---

## Stack do projeto

- **Java 21**
- **Spring Boot 4.1.0**
- **Spring Web**
- **Springdoc OpenAPI**
- **Lombok**
- **Maven Wrapper**

---

## Estrutura geral do projeto

```text
guob-jampa/
├── AGENTS.md
├── README.md
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .mvn/
├── .github/
│   └── agents/
│       ├── agente-java.agent.md
│       └── agente-professor.agent.md
├── skills/
│   ├── cleancode.md
│   └── professor.md
└── src/
    └── main/
        ├── java/
        │   └── br/edu/iesp/guobjampa/
        │       ├── GuobJampaApplication.java
        │       ├── controller/
        │       ├── service/
        │       ├── repository/
        │       ├── model/
        │       └── dto/
        └── resources/
            ├── application.properties
            └── specs/
                ├── api/
                │   └── tarefas-openapi.yaml
                └── negocio/
                    ├── produtos-negocio-parte1.md
                    └── produtos-negocio-parte2.md
```

---

## O que faz cada arquivo e pasta

### `README.md`
Documentação principal do projeto para pessoas.

**Como usar:**
- Leia primeiro para entender o objetivo do projeto.
- Consulte a estrutura e os comandos de execução.
- Use como referência geral de navegação.

---

### `AGENTS.md`
Arquivo de instruções para agentes de IA que atuam no repositório.

**Como usar:**
- Coloque aqui as regras de contexto do projeto.
- Descreva stack, limites, convenções e comandos.
- Use para orientar Copilot e outros agentes sobre como trabalhar no código.

**Conteúdo típico:**
- stack do projeto
- arquitetura
- comandos de build/test
- restrições técnicas
- localização das specs

---

### `pom.xml`
Arquivo principal do Maven.

**Como usar:**
- Define dependências, plugins e versão do projeto.
- Sempre que adicionar biblioteca nova, é aqui que a alteração entra.
- Mantém a configuração de build centralizada.

---

### `mvnw` e `mvnw.cmd`
Maven Wrapper.

**Como usar:**
- Permitem executar o Maven sem depender de instalação global.
- Use `mvnw` no Linux/macOS.
- Use `mvnw.cmd` no Windows.

---

### `.mvn/`
Arquivos internos do Maven Wrapper.

**Como usar:**
- Não costuma exigir edição manual.
- Mantém a compatibilidade do wrapper.

---

### `.github/agents/agente-java.agent.md`
Agente focado em código limpo e previsível.

**Como usar:**
- Use quando quiser gerar código objetivo, simples e bem organizado.
- Ideal para implementação técnica sem excesso de explicação.
- Deve seguir a skill `skills/cleancode.md`.

---

### `.github/agents/agente-professor.agent.md`
Agente focado em código didático e comentado.

**Como usar:**
- Use quando quiser gerar código com comentários explicativos.
- Ideal para demonstração em palestra, aula ou onboarding.
- Deve seguir a skill `skills/professor.md`.

---

### `skills/cleancode.md`
Skill com orientações de Clean Code.

**Como usar:**
- Define como o código deve ser escrito.
- Prioriza clareza, simplicidade e manutenção.
- É aplicada pelo agente `agente-java`.

**Principais regras:**
- método pequeno
- responsabilidade única
- controller sem regra de negócio
- nomes claros
- sem abstrações desnecessárias

---

### `skills/professor.md`
Skill com orientações para explicação didática.

**Como usar:**
- Define o estilo pedagógico do código gerado.
- Explica classes, métodos e anotações em linguagem simples.
- É aplicada pelo agente `agente-professor`.

**Principais regras:**
- comentários em português
- explicações curtas e úteis
- foco em aprendizado
- sem poluir o código

---

### `src/main/java/br/edu/iesp/guobjampa/GuobJampaApplication.java`
Classe principal da aplicação Spring Boot.

**Como usar:**
- É o ponto de entrada do sistema.
- O Spring usa essa classe para subir a aplicação.
- Não deve concentrar regra de negócio.

---

### `src/main/java/br/edu/iesp/guobjampa/controller/`
Camada de entrada HTTP.

**Como usar:**
- Recebe requisições da API.
- Valida dados básicos.
- Encaminha para o service.
- Não deve conter regra de negócio complexa.

---

### `src/main/java/br/edu/iesp/guobjampa/service/`
Camada de regra de negócio.

**Como usar:**
- Aqui ficam as regras centrais do sistema.
- O controller chama o service.
- O service pode usar repository e modelos internos.

---

### `src/main/java/br/edu/iesp/guobjampa/repository/`
Camada de persistência em memória.

**Como usar:**
- Armazena dados temporariamente em estruturas como `Map`.
- Não usa banco de dados.
- Serve para a demo e para manter a implementação simples.

---

### `src/main/java/br/edu/iesp/guobjampa/model/`
Modelos internos do domínio.

**Como usar:**
- Representam os dados do sistema internamente.
- Podem ser diferentes dos DTOs da API.
- Ajudam a separar domínio de contrato HTTP.

---

### `src/main/java/br/edu/iesp/guobjampa/dto/`
Objetos de entrada e saída da API.

**Como usar:**
- `Request`: dados que entram pela API.
- `Response`: dados que saem pela API.
- Evitam expor diretamente o modelo interno.

---

### `src/main/resources/application.properties`
Arquivo de configuração da aplicação.

**Como usar:**
- Define nome da aplicação, porta e configurações gerais.
- Pode concentrar parâmetros básicos do Spring Boot.
- É o local ideal para ajustes simples de runtime.

---

### `src/main/resources/specs/api/tarefas-openapi.yaml`
Spec formal da API de Tarefas.

**Como usar:**
- Serve como contrato técnico da API.
- É a base para a geração da parte OpenAPI.
- Descreve endpoints, entradas, saídas e schemas.

**Uso na demo:**
- Mostra um caso formal e objetivo.
- Ajuda o agente a gerar a estrutura da API com mais precisão.

---

### `src/main/resources/specs/negocio/produtos-negocio-parte1.md`
Primeira parte da spec de negócio da API de Produtos.

**Como usar:**
- Representa o MVP do domínio de produtos.
- Deve ser lida pelo agente como a primeira versão funcional.
- Contém regras simples e diretas.

**Uso na demo:**
- Mostra como uma spec textual já é suficiente para gerar código.
- Boa para demonstrar simplicidade e clareza.

---

### `src/main/resources/specs/negocio/produtos-negocio-parte2.md`
Segunda parte da spec de negócio da API de Produtos.

**Como usar:**
- Evolui a mesma API com novas regras.
- Representa um cenário mais próximo de projeto real.
- Deve ser usada depois da parte 1.

**Uso na demo:**
- Mostra como a IA precisa respeitar evolução de escopo.
- Ajuda a demonstrar guardrails e consistência.

---

## Como executar o projeto

### Windows

```powershell
.\mvnw.cmd clean compile
.\mvnw.cmd spring-boot:run
.\mvnw.cmd test
```

### Linux / macOS

```bash
./mvnw clean compile
./mvnw spring-boot:run
./mvnw test
```

---

## Como usar com Copilot na prática

### 1. Escolha o agente
No chat do Copilot, selecione o agente adequado:

- **Agente Java Clean Code** para código enxuto e objetivo
- **Agente Professor Fuji** para código comentado e didático

### 2. Abra a spec desejada

Exemplos:

- `src/main/resources/specs/api/tarefas-openapi.yaml`
- `src/main/resources/specs/negocio/produtos-negocio-parte1.md`
- `src/main/resources/specs/negocio/produtos-negocio-parte2.md`

### 3. Use um prompt direto

Exemplos:

```text
Use a spec em src/main/resources/specs/api/tarefas-openapi.yaml e gere a implementação da API de Tarefas.
```

```text
Use a spec em src/main/resources/specs/negocio/produtos-negocio-parte1.md e gere a API de Produtos com comentários didáticos.
```

```text
Agora considere também src/main/resources/specs/negocio/produtos-negocio-parte2.md e evolua a API de Produtos com as novas regras.
```

---

## Diretrizes do projeto

- Não usar banco de dados.
- Não usar `record`.
- Não inventar campos fora da spec.
- Não criar endpoints não previstos.
- Manter separação clara entre controller, service, model, dto e repository.
- Priorizar código legível e fácil de explicar.

---

## Cenário da palestra

Este projeto foi preparado para demonstrar:

- geração de código Java a partir de specs;
- uso de agentes com diferentes perfis;
- aplicação de skills e guardrails;
- evolução de uma spec simples para uma spec maior;
- manutenção de qualidade mesmo com apoio de IA.

---

## Resultado esperado

Ao final, o projeto deve mostrar:

- código consistente;
- geração segura;
- organização por camadas;
- diferenciação entre spec formal e spec de negócio;
- uso didático em demonstração ao vivo.

---

## Observação final

Este repositório é uma base de demonstração e aprendizado.

A ideia não é apenas gerar código, mas mostrar como fazer a IA trabalhar com mais contexto, mais regra e mais previsibilidade.