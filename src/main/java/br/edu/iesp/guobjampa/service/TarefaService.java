package br.edu.iesp.guobjampa.service;

import br.edu.iesp.guobjampa.dto.TarefaRequest;
import br.edu.iesp.guobjampa.dto.TarefaResponse;

import java.util.List;

/**
 * Contrato da camada de negocio para tarefas.
 *
 * A interface ajuda a separar a regra de negocio da camada HTTP.
 */
public interface TarefaService {

    /**
     * Lista todas as tarefas no formato de resposta da API.
     */
    List<TarefaResponse> listarTarefas();

    /**
     * Cria uma nova tarefa com base no payload recebido no endpoint.
     */
    TarefaResponse criarTarefa(TarefaRequest request);
}

