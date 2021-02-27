package br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(
		value = "Responsável Insert DTO", 
		description = "DTO utilizado para a inserção de registros na base de dados.")
public class ResponsavelInsertDto {
	@ApiModelProperty(
			value = "Nome do responsável", 
			required = true, 
			dataType = "String",
			example = "João Macedo Morais")
	private String nomeResponsavel;
}
