package br.com.esiggroup.recrutamento.taskmanager.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.TarefaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/tarefas")
@Api(tags = "Endpoints da entidade \"Tarefa\"", value = "/tarefas")
@AllArgsConstructor
public class TarefaController {
	
	private final TarefaService tarefaService;
	
	@ApiOperation(
			value = "Endpoint para listagem dos registros da tabela \"Tarefas\".",
			responseContainer = "List",
			response = TarefaDto.class,
			httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Registros recuperados com sucesso."),
			@ApiResponse(code = 204, message = "Nenhum registro encontrado.", response = Object.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor!") })
	@GetMapping
	public ResponseEntity<List<TarefaDto>> get(){
		return ResponseEntity.status(HttpStatus.OK).body(tarefaService.findAll());
	}
	
	@ApiOperation(
			value = "Endpoint para cadastrar uma nova tarefa no banco de dados.",
			response = TarefaDto.class,
			httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Tarefa cadastrada com sucesso!"),
		@ApiResponse(code = 500, message = "Erro interno do servidor!")})
	@PostMapping
	public ResponseEntity<TarefaDto> save(@RequestBody TarefaInsertDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.save(dto));
	}
}
