package br.edu.iesp.guobjampa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de saida da API de tarefas.
 *
 * Este contrato representa exatamente o JSON devolvido nos endpoints.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaResponse {
    private Long id;
    private String titulo;
    private Boolean concluida;
}

