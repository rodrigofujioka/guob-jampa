package br.edu.iesp.guobjampa.controller;

import br.edu.iesp.guobjampa.dto.TarefaRequest;
import br.edu.iesp.guobjampa.dto.TarefaResponse;
import br.edu.iesp.guobjampa.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TarefaController.java
 *
 * Controller REST (fronteira HTTP) que expõe os endpoints da API de Tarefas.
 * Aqui chegam as requisições HTTP e aqui retornam as respostas.
 *
 * Anotações:
 * - @RestController: marca como controlador REST (combina @Controller + @ResponseBody)
 * - @RequestMapping: prefixo de rota (todos os endpoints começam com /tarefas)
 * - @RequiredArgsConstructor: Lombok, injeta o service via construtor
 *
 * Responsiblidades do Controller:
 * - Receber e validar requisições HTTP
 * - Chamar o serviço (que contém a lógica)
 * - Retornar respostas HTTP com o status correto
 */
@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    // O serviço é injetado aqui pelo Spring
    private final TarefaService tarefaService;

    /**
     * GET /tarefas
     *
     * Lista todas as tarefas.
     *
     * Anotações:
     * - @GetMapping: maps a requisição GET para este método
     * - Retorna: List<TarefaResponse> com status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<TarefaResponse>> listar() {
        // Chama o serviço (que traz as tarefas do repositório)
        List<TarefaResponse> tarefas = tarefaService.listar();

        // Retorna com status 200 (OK)
        return ResponseEntity.ok(tarefas);
    }

    /**
     * POST /tarefas
     *
     * Cria uma nova tarefa.
     *
     * Anotações:
     * - @PostMapping: maps a requisição POST para este método
     * - @Valid: ativa as validações do TarefaRequest (jakarta.validation)
     * - @RequestBody: converte o JSON do corpo da requisição para TarefaRequest
     *
     * Fluxo:
     * 1. O Spring valida o TarefaRequest (verifica @NotBlank, @Size, etc)
     * 2. Se inválido, retorna 400 automaticamente (trata no GlobalExceptionHandler)
     * 3. Se válido, passa para this.criar()
     * 4. O serviço cria a tarefa e retorna o DTO
     * 5. Retorna com status 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<TarefaResponse> criar(@Valid @RequestBody TarefaRequest request) {
        // Chama o serviço para criar a tarefa
        TarefaResponse resposta = tarefaService.criar(request);

        // Retorna com status 201 (CREATED) e o DTO da tarefa criada
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }
}

