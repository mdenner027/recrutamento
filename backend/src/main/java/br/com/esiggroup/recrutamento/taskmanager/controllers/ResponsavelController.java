package br.com.esiggroup.recrutamento.taskmanager.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.ResponsavelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/responsaveis")
@Api(tags = "Endpoints da entidade \"Responsável\"",value = "/responsaveis")
@AllArgsConstructor
public class ResponsavelController {
	
	private final ResponsavelService responService;
	
	@ApiOperation(
			value = "Endpoint para listagem dos registros da tabela \"Responsaveis\".",
			responseContainer = "List",
			response = ResponsavelDto.class,
			httpMethod = "GET")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Registros recuperados com sucesso."),
			@ApiResponse(code = 204, message = "Nenhum registro encontrado.", response = Object.class),
			@ApiResponse(code = 500, message = "Erro interno do servidor!") })
	@GetMapping
	public ResponseEntity<List<ResponsavelDto>> get() {
		return ResponseEntity.status(HttpStatus.OK).body(responService.findAll());
	}

	
	@ApiOperation(
			value = "Endpoint para recuperar um registro específico da tabela de responsáveis.", 
			response = ResponsavelDto.class, 
			httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Registro recuperado com sucesso!"),
		@ApiResponse(code = 404, message = "Nenhum registro encontrado com o identificador informado."),
		@ApiResponse(code = 500, message = "Erro interno do servidor!")
	})
	@GetMapping(value = "/{idResponsavel}")
	public ResponseEntity<ResponsavelDto> get(@PathVariable Long idResponsavel) {
		return ResponseEntity.status(HttpStatus.OK).body(responService.findById(idResponsavel));
	}
	
	@ApiOperation(
			value = "Endpoint para cadastrar um novo responsável.", 
			response = ResponsavelDto.class, 
			httpMethod = "POST")
	@ApiResponses({ 
			@ApiResponse(code = 201, message = "Registro cadastrado com sucesso!"),
			@ApiResponse(code = 500, message = "Erro interno do servidor.") })
	@PostMapping
	public ResponseEntity<ResponsavelDto> save(@RequestBody ResponsavelInsertDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(responService.save(dto));
	}
	
	
	@ApiOperation(
			value = "Endpoint para atualizar um determinado registro.",
			response = ResponsavelDto.class,
			httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Registro atualizado com sucesso!"),
		@ApiResponse(code = 500, message = "Erro interno do servidor!")
	})
	@PutMapping
	public ResponseEntity<ResponsavelDto> update(@RequestBody ResponsavelDto dto) {
		return ResponseEntity.status(HttpStatus.OK).body(responService.update(dto));
	}
	
	
	@ApiOperation(
			value="Endpoint para remoção de um registro",
			response = Void.class,
			httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Registro removido com sucesso!"),
		@ApiResponse(code = 404, message = "Nenhum registro encontrado com o identificador informado."),
		@ApiResponse(code = 500, message = "Erro interno do servidor!")
	})
	@DeleteMapping("/{idResponsavel}")
	public ResponseEntity<Void> delete(@PathVariable Long idResponsavel) {
		responService.delete(idResponsavel);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
