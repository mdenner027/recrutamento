package br.com.esiggroup.recrutamento.taskmanager.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.esiggroup.recrutamento.taskmanager.enums.StatusTarefa;
import br.com.esiggroup.recrutamento.taskmanager.models.Responsavel;
import br.com.esiggroup.recrutamento.taskmanager.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	Tarefa findByIdTarefa(Long idTarefa);
	
	@Query("Select t From Tarefa t where t.tituloTarefa like ?1 OR t.descricaoTarefa like ?1")
	Set<Tarefa> findByTituloOuDescricao(String tituloTarefa);
	
	Set<Tarefa> findByResponsavelTarefa(Responsavel responsavelTarefa);
	
	Set<Tarefa> findByStatusTarefa(StatusTarefa statusTarefa);
}
