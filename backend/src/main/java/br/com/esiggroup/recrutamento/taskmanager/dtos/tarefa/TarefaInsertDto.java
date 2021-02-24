package br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa;

import java.util.Calendar;

import br.com.esiggroup.recrutamento.taskmanager.enums.PrioridadeTarefa;
import br.com.esiggroup.recrutamento.taskmanager.models.Responsavel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(
		value = "Tarefa Inser DTO",
		description = "DTO utilizado para a inserção de registros na base de dados.")
public class TarefaInsertDto {
	@ApiModelProperty(
			position = 1,
			name = "Título da Tarefa",
			dataType = "String",
			example = "Ex.: Testar módulo de vendas.")
	private String tituloTarefa;

	@ApiModelProperty(
			position = 2,
			name = "Descrição da Tarefa",
			dataType = "String",
			example = "Ex.: Testar todos os módulos e validar as operações com os outros membros.")
	private String descricaoTarefa;

	@ApiModelProperty(
			position = 3,
			name = "Prioridade da Tarefa",
			dataType = "Integer",
			value = "Valor numérico para indicar a prioridade da tarefa (0 - Baixa, 1 - Média, 2 - Alta)",
			example = "Ex.: 1.")
	private PrioridadeTarefa prioridadeTarefa;

	@ApiModelProperty(
			position = 4,
			name = "Deadline da tarefa",
			dataType = "Calendar",
			example = "Ex.: 20/03/2021.")
	private Calendar deadlineTarefa;

	@ApiModelProperty(
			position = 5,
			name = "Responsável pela Tarefa",
			dataType = "Long",
			example = "Ex.: Testar módulo de vendas.")
	private Responsavel responsavelTarefa;
}
