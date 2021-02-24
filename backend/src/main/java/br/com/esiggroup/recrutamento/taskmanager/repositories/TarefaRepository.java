package br.com.esiggroup.recrutamento.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.esiggroup.recrutamento.taskmanager.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
