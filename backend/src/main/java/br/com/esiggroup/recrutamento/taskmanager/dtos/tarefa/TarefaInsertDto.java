package br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa;


import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelDto;
import br.com.esiggroup.recrutamento.taskmanager.enums.PrioridadeTarefa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(
		value = "Tarefa Insert DTO",
		description = "DTO utilizado para a inserção de registros na base de dados.")
public class TarefaInsertDto {
	@ApiModelProperty(
			position = 1,
			name = "Título da Tarefa",
			value = "Título com breve descrição",
			dataType = "String",
			example = "Testar módulo de vendas.")
	private String tituloTarefa;

	@ApiModelProperty(
			position = 2,
			name = "Descrição da Tarefa",
			dataType = "String",
			example = "Testar todos os módulos e validar as operações com os outros membros.")
	private String descricaoTarefa;

	@ApiModelProperty(
			position = 3,
			name = "Prioridade da Tarefa",
			dataType = "Integer",
			value = "Valor numérico para indicar a prioridade da tarefa (0 - Baixa, 1 - Média, 2 - Alta)",
			example = "1")
	private PrioridadeTarefa prioridadeTarefa;

	@ApiModelProperty(
			position = 4,
			name = "Deadline da tarefa",
			value = "Deadline da tarefa em formato textual",
			dataType = "String",
			example = "20/03/2021")
	private String deadlineTarefa;

	@ApiModelProperty(
			position = 5,
			name = "Responsável pela Tarefa",
			value = "Identificado do responsável pela tarefa",
			dataType = "ResponsavelDto")
	private ResponsavelDto responsavelTarefa;
}
