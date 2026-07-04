package br.edu.iesp.guobjampa.service;

import br.edu.iesp.guobjampa.dto.TarefaRequest;
import br.edu.iesp.guobjampa.dto.TarefaResponse;

import java.util.List;

/**
 * TarefaService.java
 *
 * Interface que define o contrato (as operações públicas) do serviço de tarefas.
 *
 * Por que usar interface?
 * - Define um contrato que qualquer implementação deve seguir
 * - Faz o código mais testável (podemos substituir por mock em testes)
 * - Permite mudanças na implementação sem afetar quem usa a interface
 *
 * Localização da interface:
 * - service/ (nível de negócio)
 */
public interface TarefaService {
    /**
     * Lista todas as tarefas.
     * @return Lista de TarefaResponse (DTOs de resposta)
     */
    List<TarefaResponse> listar();

    /**
     * Cria uma nova tarefa.
     * @param request DTO com os dados da tarefa (vindo da API)
     * @return TarefaResponse com a tarefa criada (incluindo o ID gerado)
     */
    TarefaResponse criar(TarefaRequest request);
}

