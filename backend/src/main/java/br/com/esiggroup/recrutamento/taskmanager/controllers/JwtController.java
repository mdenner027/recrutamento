package br.com.esiggroup.recrutamento.taskmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtRequest;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtResponse;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(tags = { "login e cadastro" })
public class JwtController {

	private final LoginService loginService;

	@ApiOperation(
			value = "Endpoint para a realização do login e obtenção do JWT token.",
			response = JwtResponse.class,
			httpMethod = "POST")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "JWT token gerado com sucesso."),
			@ApiResponse(code = 401, message = "Usuário não autorizado"),
			@ApiResponse(code = 500, message = "Erro interno do servidor!") })
	@PostMapping(value = "/login")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(loginService.login(authenticationRequest));
	}

	@ApiOperation(
			value = "Endpoint para cadastro de novos usuários.",
			response = JwtResponse.class,
			httpMethod = "POST")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Usuário criado com sucesso!"),
			@ApiResponse(code = 500, message = "Erro interno do servidor!") })
	@PostMapping(value = "/signup")
	public ResponseEntity<UsuarioDto> saveUser(@RequestBody UsuarioDto usuario) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(loginService.save(usuario));
	}
}
