package br.edu.iesp.guobjampa.service.impl;

import br.edu.iesp.guobjampa.dto.TarefaRequest;
import br.edu.iesp.guobjampa.dto.TarefaResponse;
import br.edu.iesp.guobjampa.model.Tarefa;
import br.edu.iesp.guobjampa.repository.InMemoryTarefaRepository;
import br.edu.iesp.guobjampa.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacao da regra de negocio de tarefas.
 *
 * @Service marca esta classe como servico gerenciado pelo Spring.
 * @RequiredArgsConstructor cria construtor com campos final para injecao automatica.
 */
@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final InMemoryTarefaRepository repository;

    /**
     * Busca todas as tarefas no repositorio e converte para DTO de resposta.
     */
    @Override
    public List<TarefaResponse> listarTarefas() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * Cria uma tarefa nova ja com status concluida = false, conforme a spec.
     */
    @Override
    public TarefaResponse criarTarefa(TarefaRequest request) {
        Tarefa novaTarefa = Tarefa.builder()
                .titulo(request.getTitulo())
                .concluida(false)
                .build();

        Tarefa salva = repository.save(novaTarefa);
        return toResponse(salva);
    }

    private TarefaResponse toResponse(Tarefa tarefa) {
        return TarefaResponse.builder()
                .id(tarefa.getId())
                .titulo(tarefa.getTitulo())
                .concluida(tarefa.getConcluida())
                .build();
    }
}

