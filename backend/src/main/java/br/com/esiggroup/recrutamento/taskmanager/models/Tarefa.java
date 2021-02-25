package br.com.esiggroup.recrutamento.taskmanager.models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.esiggroup.recrutamento.taskmanager.enums.PrioridadeTarefa;
import br.com.esiggroup.recrutamento.taskmanager.enums.StatusTarefa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
public class Tarefa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarefa", nullable = false, unique = true)
	private Long idTarefa;

	@Column(name = "titulo_tarefa", nullable = false)
	private String tituloTarefa;

	@Column(name = "descricao_tarefa", nullable = false)
	private String descricaoTarefa;

	@Column(name = "prioridade_tarefa", nullable = false)
	private PrioridadeTarefa prioridadeTarefa;

	@Column(name = "status_tarefa", nullable = false)
	private StatusTarefa statusTarefa;

	@Temporal(TemporalType.DATE)
	@Column(name = "deadline_tarefa", nullable = false)
	private Calendar deadlineTarefa;

	@JsonBackReference
	@ManyToOne(targetEntity = Responsavel.class)
	@JoinColumn(name = "id_responsavel_tarefa")
	private Responsavel responsavelTarefa;
}
