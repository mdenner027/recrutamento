package br.com.esiggroup.recrutamento.taskmanager.models;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@ApiModel(
		value = "Jwt Response",
		description = "Entidade utilizada para retornar o token JWT.")
public class JwtResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Setter(value = AccessLevel.NONE)
	@Getter(value = AccessLevel.NONE)
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	@ApiModelProperty(name = "Token JWT", value = "Token gerado.")
	public String getToken() {
		return this.jwttoken;
	}

}
