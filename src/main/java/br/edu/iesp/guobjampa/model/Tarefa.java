package br.edu.iesp.guobjampa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model/Tarefa.java
 *
 * Representa uma tarefa no sistema. Esta é a entidade de domínio que será
 * armazenada em memória.
 *
 * Anotações Lombok:
 * - @Data: gera automaticamente getters, setters, equals, hashCode, toString
 * - @Builder: permite criar objetos com padrão builder (ex: Tarefa.builder().id(1L).titulo("Test").build())
 * - @NoArgsConstructor: gera um construtor vazio (necessário para frameworks)
 * - @AllArgsConstructor: gera um construtor com todos os campos
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    // ID único da tarefa (autoincremento será feito no repositório)
    private Long id;

    // Título da tarefa (obrigatório)
    private String titulo;

    // Status de conclusão (padrão: false, ou seja, não concluída)
    private Boolean concluida;
}

