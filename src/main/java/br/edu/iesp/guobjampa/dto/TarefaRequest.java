package br.edu.iesp.guobjampa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de entrada da API de tarefas.
 *
 * Aqui declaramos somente o que o cliente pode enviar no POST /tarefas.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaRequest {

    /**
     * @NotBlank garante que o titulo seja informado e nao seja vazio.
     * @Size aplica as regras da spec (entre 3 e 100 caracteres).
     */
    @NotBlank(message = "titulo e obrigatorio")
    @Size(min = 3, max = 100, message = "titulo deve ter entre 3 e 100 caracteres")
    private String titulo;
}

