package br.com.esiggroup.recrutamento.taskmanager.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "responsaveis")
@Getter
@Setter
@NoArgsConstructor
public class Responsavel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_responsavel", nullable = false, unique = true)
	private Long idResponsavel;

	@Column(name = "nome_responsavel", unique = true)
	private String nomeResponsavel;

	@JsonManagedReference
	@Setter(value = AccessLevel.NONE)
	@OneToMany(mappedBy = "responsavelTarefa", orphanRemoval = true, targetEntity = Tarefa.class)
	private Set<Tarefa> tarefasResponsavel;
}
