package br.com.esiggroup.recrutamento.taskmanager.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.enums.StatusTarefa;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.TarefaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/tarefas")
@Api(tags = {"tarefas"} )
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
			value = "Endpoint para buscar uma tarefa específica.",
			response = TarefaDto.class,
			httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Registro recuperado com sucesso."),
			@ApiResponse(code = 204, message = "Nenhum registro encontrado.", response = Object.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor!") })
	@GetMapping(value = "/{idTarefa}")
	public ResponseEntity<TarefaDto> get(@PathVariable Long idTarefa) {
		return ResponseEntity.status(HttpStatus.OK).body(tarefaService.findById(idTarefa));
	}
	
	
	@ApiOperation(
			value = "Endpoint para filtrar tarefas.",
			response = TarefaDto.class,
			responseContainer = "List",
			httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Registros recuperados com sucesso."),
			@ApiResponse(code = 204, message = "Nenhum registro encontrado.", response = Object.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor!") })
	@GetMapping("/filter")
	public ResponseEntity<List<TarefaDto>> get(
			@RequestParam(required = false, defaultValue = "", name = "idTarefa") Long idTarefa,
			@RequestParam(required = false, defaultValue = "", name = "tituloOuDescricao") String tituloDescricao,
			@RequestParam(required = false, defaultValue = "", name = "statusTarefa") StatusTarefa status,
			@RequestParam(required = false, defaultValue = "",name = "idResponsavel") Long idResponsavel) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(tarefaService.filter(idTarefa, tituloDescricao, status, idResponsavel));
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
	
	
	@ApiOperation(
			value = "Endpoint para atualizar uma tarefa no banco de dados.",
			response = TarefaDto.class,
			httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarefa cadastrada com sucesso!"),
		@ApiResponse(code = 404, message = "Tarefa não encontrada."),
		@ApiResponse(code = 500, message = "Erro interno do servidor!")})
	@PutMapping
	public ResponseEntity<TarefaDto> update(@RequestBody TarefaDto dto) {
		return ResponseEntity.status(HttpStatus.OK).body(tarefaService.update(dto));
	}
	
	@ApiOperation(
			value = "Endpoint para marcar uma tarefa como finalizada.",
			response = TarefaDto.class,
			httpMethod = "PATCH")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarefa finzalizada com sucesso!"),
		@ApiResponse(code = 404, message = "Tarefa não encontrada."),
		@ApiResponse(code = 500, message = "Erro interno do servidor!")
	})
	@PatchMapping("/{idTarefa}")
	public ResponseEntity<TarefaDto> complete(@PathVariable(name = "idTarefa") Long idTarefa) {
		return ResponseEntity.status(HttpStatus.OK).body(tarefaService.complete(idTarefa));
	}
	
	
	@ApiOperation(
			value = "Endpoint deletar uma tarefa do banco de dados.",
			response = Object.class,
			httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Tarefa finzalizada com sucesso!"),
		@ApiResponse(code = 404, message = "Tarefa não encontrada."),
		@ApiResponse(code = 500, message = "Erro interno do servidor!")
	})
	@DeleteMapping("/{idTarefa}")
	public ResponseEntity<Void> delete(@PathVariable(name = "idTarefa") Long idTarefa) {
		tarefaService.delete(idTarefa);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
