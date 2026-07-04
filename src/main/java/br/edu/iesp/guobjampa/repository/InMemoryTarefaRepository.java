package br.edu.iesp.guobjampa.repository;

import br.edu.iesp.guobjampa.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * InMemoryTarefaRepository.java
 *
 * Repositório em memória para armazenar tarefas. Usa um HashMap (ConcurrentHashMap
 * para thread-safety) como banco de dados "virtual".
 *
 * Anotação @Repository:
 * - Marca a classe como um componente de persistência do Spring
 * - Permite que a classe seja detectada automaticamente e injetada com @Autowired
 *
 * Por que ConcurrentHashMap?
 * - Garante que múltiplas threads possam acessar simultaneamente sem quebrar os dados
 * - Importante em aplicações web onde múltiplas requisições chegam ao mesmo tempo
 */
@Repository
public class InMemoryTarefaRepository {
    // Map que armazena as tarefas: chave = ID, valor = Tarefa
    private final ConcurrentHashMap<Long, Tarefa> armazenamento = new ConcurrentHashMap<>();

    // Contador para gerar IDs únicos incrementais
    private final AtomicLong contador = new AtomicLong(0);

    /**
     * Busca todas as tarefas.
     * @return Lista com todas as tarefas armazenadas
     */
    public List<Tarefa> findAll() {
        return new ArrayList<>(armazenamento.values());
    }

    /**
     * Busca uma tarefa pelo ID.
     * @param id o ID da tarefa
     * @return Optional com a tarefa (vazio se não encontrar)
     */
    public Optional<Tarefa> findById(Long id) {
        return Optional.ofNullable(armazenamento.get(id));
    }

    /**
     * Salva (ou atualiza) uma tarefa.
     *
     * Se o ID for nulo, gera um novo ID. Caso contrário, atualiza a existente.
     *
     * @param tarefa a tarefa a salvar
     * @return a tarefa salva com o ID preenchido
     */
    public Tarefa save(Tarefa tarefa) {
        // Se não tem ID, gera um novo incrementando o contador
        if (tarefa.getId() == null) {
            tarefa.setId(contador.incrementAndGet());
        }

        // Guarda no Map usando o ID como chave
        armazenamento.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    /**
     * Deleta uma tarefa pelo ID.
     * @param id o ID da tarefa a deletar
     */
    public void deleteById(Long id) {
        armazenamento.remove(id);
    }
}

