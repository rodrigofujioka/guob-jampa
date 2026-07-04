package br.edu.iesp.guobjampa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TarefaRequest.java
 *
 * DTO (Data Transfer Object) para recebimento de requisições POST/PUT.
 * Fica na "fronteira da API" (boundary) e contém as validações que o cliente
 * deve respeitar ao enviar dados.
 *
 * Anotações de validação (Jakarta Validation):
 * - @NotBlank: garante que o campo não é vazio e não é apenas espaços em branco
 * - @Size: limita o tamanho mínimo e máximo da string (conforme spec: 3-100)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaRequest {
    // Título obrigatório, entre 3 e 100 caracteres
    @NotBlank(message = "Título é obrigatório")
    @Size(min = 3, max = 100, message = "Título deve ter entre 3 e 100 caracteres")
    private String titulo;
}

