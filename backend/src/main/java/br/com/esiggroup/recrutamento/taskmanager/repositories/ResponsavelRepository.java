package br.com.esiggroup.recrutamento.taskmanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.esiggroup.recrutamento.taskmanager.models.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {
	Responsavel findByIdResponsavel(Long id);
	
}
