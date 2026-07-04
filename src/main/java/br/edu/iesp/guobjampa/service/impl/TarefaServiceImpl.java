package br.edu.iesp.guobjampa.service.impl;

import br.edu.iesp.guobjampa.dto.TarefaRequest;
import br.edu.iesp.guobjampa.dto.TarefaResponse;
import br.edu.iesp.guobjampa.model.Tarefa;
import br.edu.iesp.guobjampa.repository.InMemoryTarefaRepository;
import br.edu.iesp.guobjampa.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TarefaServiceImpl.java
 *
 * Implementação do contrato TarefaService. Aqui fica a lógica de negócio:
 * - Conversões entre DTOs e Models
 * - Regras de negócio (como tarefas são criadas, listadas, etc)
 *
 * Anotações:
 * - @Service: marca como componente de serviço/negócio
 * - @RequiredArgsConstructor: do Lombok, gera construtor com fields final (injeção de dependência)
 *
 * Padrão de Design:
 * - Injeção de Dependência: o repositório é injetado no construtor
 * - Data Transfer Object (DTO): conversão entre camadas (DTO <-> Model)
 */
@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {
    // O repositório é injetado aqui pelo Spring
    private final InMemoryTarefaRepository repositorio;

    /**
     * Lista todas as tarefas.
     *
     * Passo a passo:
     * 1. Busca todas as tarefas do repositório (retorna Tarefa models)
     * 2. Converte cada Tarefa para TarefaResponse (DTO) usando streams
     * 3. Retorna a lista de DTOs para o cliente
     */
    @Override
    public List<TarefaResponse> listar() {
        return repositorio.findAll()
                .stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    /**
     * Cria uma nova tarefa.
     *
     * Passo a passo:
     * 1. Converte o TarefaRequest (DTO vindo da API) para Tarefa (model)
     * 2. Define concluida como false (nova tarefa sempre começa não-concluída)
     * 3. Salva no repositório (que gera o ID automaticamente)
     * 4. Converte de volta para TarefaResponse (DTO com o ID gerado)
     */
    @Override
    public TarefaResponse criar(TarefaRequest request) {
        // 1. Cria um novo modelo Tarefa a partir do request
        Tarefa tarefa = Tarefa.builder()
                .titulo(request.getTitulo())
                .concluida(false)  // Padrão: tarefa é criada não-concluída
                .build();

        // 2. Salva no repositório (recebe de volta com ID preenchido)
        Tarefa tarefaSalva = repositorio.save(tarefa);

        // 3. Converte para DTO de resposta e retorna
        return converterParaResponse(tarefaSalva);
    }

    /**
     * Método auxiliar: converte um Model Tarefa para DTO TarefaResponse.
     *
     * Esta é uma conversão simples, apenas mapeando campos.
     * Se um dia houver campos calculados, editamos aqui.
     */
    private TarefaResponse converterParaResponse(Tarefa tarefa) {
        return TarefaResponse.builder()
                .id(tarefa.getId())
                .titulo(tarefa.getTitulo())
                .concluida(tarefa.getConcluida())
                .build();
    }
}

