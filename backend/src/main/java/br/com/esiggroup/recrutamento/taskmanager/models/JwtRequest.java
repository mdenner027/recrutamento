package br.com.esiggroup.recrutamento.taskmanager.models;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(
		value = "Jwt Request",
		description = "Entidade utilizada para efetuar login no sistema e ser gerado o JWT token.")
public class JwtRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(
			position = 1,
			name = "Login",
			value = "Login do usuário.",
			dataType = "String",
			example = "usuario01")
	private String loginUsuario;
	
	@ApiModelProperty(
			position = 2,
			name = "Senha",
			value = "Senha do usuário.",
			dataType = "String",
			example = "12345")
	private String senhaUsuario;

}
