# Spec de Negócio — Produtos (Parte 1: MVP)

## Objetivo

Criar uma API REST simples para gerenciamento de produtos.
Esta é a versão inicial (MVP), com o mínimo necessário para funcionar.

## Endpoints

### Listar produtos
- **Método:** GET
- **Caminho:** /produtos
- **Descrição:** Retorna todos os produtos cadastrados.
- **Resposta:** lista de produtos com id, nome, preco e ativo.

### Criar produto
- **Método:** POST
- **Caminho:** /produtos
- **Descrição:** Cadastra um novo produto.
- **Resposta:** produto criado com id gerado automaticamente.

## Modelo de dados

| Campo  | Tipo    | Obrigatório | Observação                        |
|--------|---------|-------------|-----------------------------------|
| id     | inteiro | não         | gerado automaticamente            |
| nome   | texto   | sim         | mínimo 3 caracteres               |
| preco  | decimal | sim         | deve ser maior que zero           |
| ativo  | boolean | não         | começa sempre como true           |

## Regras de negócio

- O campo `nome` é obrigatório e deve ter no mínimo 3 caracteres.
- O campo `preco` é obrigatório e deve ser maior que zero.
- O campo `ativo` não precisa ser enviado na criação; sempre começa como `true`.
- O campo `id` é gerado automaticamente pela aplicação.
- Não é permitido criar produto com nome duplicado.

## Restrições técnicas

- Não usar banco de dados.
- Armazenar os dados em memória usando Map.
- Não criar endpoints além dos descritos aqui.
- Não adicionar campos além dos descritos no modelo.
- Não usar `record`.

## Exemplo de requisição

### POST /produtos
```json
{
  "nome": "Notebook Dell",
  "preco": 4500.00
}
```

### Resposta esperada
```json
{
  "id": 1,
  "nome": "Notebook Dell",
  "preco": 4500.00,
  "ativo": true
}
```
