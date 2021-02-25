package br.com.esiggroup.recrutamento.taskmanager.services.interfaces;

import java.util.List;

import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelInsertDto;

public interface ResponsavelService {
	ResponsavelDto save(ResponsavelInsertDto dto);

	ResponsavelDto findById(Long idResponsavel);

	ResponsavelDto update(ResponsavelDto dto);

	List<ResponsavelDto> findAll();

	void delete(Long idResponsavel);
	
	Boolean existResponsavel(Long idResponsavel);
}
