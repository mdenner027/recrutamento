package br.com.esiggroup.recrutamento.taskmanager.services.interfaces;

import java.util.List;

import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaInsertDto;

public interface TarefaService {

	List<TarefaDto> findAll();

	TarefaDto findById(Long idTarefa);

	TarefaDto save(TarefaInsertDto dto);

	TarefaDto complete(Long idTarefa);

	void delete(Long idTarefa);
}
