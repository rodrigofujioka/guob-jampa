package br.edu.iesp.guobjampa.controller;

import br.edu.iesp.guobjampa.dto.TarefaRequest;
import br.edu.iesp.guobjampa.dto.TarefaResponse;
import br.edu.iesp.guobjampa.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Esta classe expoe os endpoints HTTP da API de Tarefas.
 *
 * @RestController indica que os metodos respondem requisicoes web retornando JSON.
 * @RequestMapping("/tarefas") define o caminho base de todos os endpoints daqui.
 */
@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    /**
     * Endpoint GET /tarefas.
     * Recebe: nada no corpo da requisicao.
     * Faz: busca as tarefas no servico.
     * Retorna: lista de TarefaResponse com status 200.
     */
    @GetMapping
    public List<TarefaResponse> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    /**
     * Endpoint POST /tarefas.
     * Recebe: TarefaRequest validado automaticamente pelo Spring com @Valid.
     * Faz: cria a tarefa chamando a camada de servico.
     * Retorna: tarefa criada com status 201.
     */
    @PostMapping
    public ResponseEntity<TarefaResponse> criarTarefa(@Valid @RequestBody TarefaRequest request) {
        TarefaResponse response = tarefaService.criarTarefa(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

