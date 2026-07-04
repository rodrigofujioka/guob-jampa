package br.edu.iesp.guobjampa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TarefaResponse.java
 *
 * DTO (Data Transfer Object) para envio de respostas da API.
 * Contém os campos que queremos que o cliente receba, já convertidos de Tarefa
 * (o model interno).
 *
 * Não tem validações porque é apenas para retorno (saída de dados).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaResponse {
    // ID da tarefa
    private Long id;

    // Título da tarefa
    private String titulo;

    // Status de conclusão (true = concluída, false = não concluída)
    private Boolean concluida;
}

