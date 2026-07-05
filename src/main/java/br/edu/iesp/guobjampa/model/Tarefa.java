package br.edu.iesp.guobjampa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modelo de dominio da tarefa dentro da aplicacao.
 *
 * Ele representa como a tarefa fica armazenada em memoria.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    private Long id;
    private String titulo;
    private Boolean concluida;
}

