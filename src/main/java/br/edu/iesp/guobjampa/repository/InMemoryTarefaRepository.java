package br.edu.iesp.guobjampa.repository;

import br.edu.iesp.guobjampa.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repositorio em memoria para a entidade Tarefa.
 *
 * @Repository indica para o Spring que esta classe participa da camada de dados.
 * Aqui usamos Map para guardar os dados sem banco, como definido no projeto.
 */
@Repository
public class InMemoryTarefaRepository {

    private final Map<Long, Tarefa> tarefas = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    /**
     * Retorna todas as tarefas cadastradas ordenadas por id.
     */
    public List<Tarefa> findAll() {
        List<Tarefa> lista = new ArrayList<>(tarefas.values());
        lista.sort(Comparator.comparing(Tarefa::getId));
        return lista;
    }

    /**
     * Salva uma nova tarefa em memoria, gerando id automaticamente.
     */
    public Tarefa save(Tarefa tarefa) {
        Long novoId = sequence.incrementAndGet();
        tarefa.setId(novoId);
        tarefas.put(novoId, tarefa);
        return tarefa;
    }
}

