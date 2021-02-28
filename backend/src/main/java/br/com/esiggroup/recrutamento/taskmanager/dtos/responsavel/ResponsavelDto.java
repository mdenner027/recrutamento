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
		value = "Responsável DTO", 
		description = "DTO padrão para a representação da entidade \"responsável\".")
public class ResponsavelDto {
	@ApiModelProperty(
			value = "Identificador numérico do responsável", 
			required = true, 
			dataType = "Long",
			position = 1,
			example = "1")
	private Long idResponsavel;
	
	@ApiModelProperty(
			value = "Nome do responsável", 
			required = true, 
			dataType = "String",
			position = 2,
			example = "João Macedo Morais")
	private String nomeResponsavel;
}
