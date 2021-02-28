package br.com.esiggroup.recrutamento.taskmanager.services.interfaces;

import java.util.List;

import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.enums.StatusTarefa;

public interface TarefaService {

	List<TarefaDto> findAll();

	List<TarefaDto> filter(Long idTarefa, String tituloDescricao, StatusTarefa status, Long idResponsavel);
	
	TarefaDto findById(Long idTarefa);

	TarefaDto save(TarefaInsertDto dto);

	TarefaDto complete(Long idTarefa);
	
	TarefaDto update(TarefaDto dto);

	void delete(Long idTarefa);
}
