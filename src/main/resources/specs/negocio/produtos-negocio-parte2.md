# Spec de Negócio — Produtos (Parte 2: Evolução)

## Objetivo

Evoluir a API de Produtos com novas regras de negócio,
mantendo a mesma base da Parte 1 sem aumentar a complexidade desnecessariamente.

## O que muda em relação à Parte 1

- Adição do campo `categoria`.
- Adição de filtros na listagem.
- Nova regra de validação de `preco`.

## Endpoints

### Listar produtos (atualizado)
- **Método:** GET
- **Caminho:** /produtos
- **Descrição:** Retorna produtos com filtros opcionais.
- **Parâmetros opcionais:**
    - `categoria` (texto): filtra por categoria.
    - `ativo` (boolean): filtra por status ativo/inativo.

### Criar produto (atualizado)
- **Método:** POST
- **Caminho:** /produtos
- **Descrição:** Cadastra um novo produto com categoria obrigatória.

## Modelo de dados atualizado

| Campo     | Tipo    | Obrigatório | Observação                              |
|-----------|---------|-------------|-----------------------------------------|
| id        | inteiro | não         | gerado automaticamente                  |
| nome      | texto   | sim         | mínimo 3 caracteres                     |
| preco     | decimal | sim         | deve ser maior que zero e menor que 100.000 |
| ativo     | boolean | não         | começa sempre como true                 |
| categoria | texto   | sim         | valores permitidos: ELETRONICO, LIVRO, ALIMENTO |

## Regras de negócio

- O campo `categoria` passa a ser **obrigatório**.
- Valores permitidos para `categoria`: `ELETRONICO`, `LIVRO`, `ALIMENTO`.
- O campo `preco` deve ser maior que zero e **menor que 100.000**.
- Não é permitido criar produto com nome duplicado.
- O campo `ativo` continua começando sempre como `true`.
- O `id` continua sendo gerado automaticamente.

## Filtros na listagem

- `GET /produtos` retorna todos os produtos.
- `GET /produtos?categoria=LIVRO` retorna apenas livros.
- `GET /produtos?ativo=false` retorna apenas produtos inativos.
- `GET /produtos?categoria=ELETRONICO&ativo=true` combina os dois filtros.

## Restrições técnicas (mantidas da Parte 1)

- Não usar banco de dados.
- Continuar usando Map em memória.
- Não criar endpoints além dos descritos.
- Não adicionar campos além dos descritos.
- Não usar `record`.

## Exemplo de requisição

### POST /produtos
```json
{
  "nome": "Clean Code",
  "preco": 89.90,
  "categoria": "LIVRO"
}
```

### Resposta esperada
```json
{
  "id": 2,
  "nome": "Clean Code",
  "preco": 89.90,
  "ativo": true,
  "categoria": "LIVRO"
}
```

### GET /produtos?categoria=LIVRO
```json
[
  {
    "id": 2,
    "nome": "Clean Code",
    "preco": 89.90,
    "ativo": true,
    "categoria": "LIVRO"
  }
]
```
