package br.com.esiggroup.recrutamento.taskmanager.dtos.usuario;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(
		value = "Usuário DTO",
		description = "DTO padrão para entidade Usuário.")
public class UsuarioDto {
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
