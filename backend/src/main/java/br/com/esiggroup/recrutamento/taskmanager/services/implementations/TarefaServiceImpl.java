package br.com.esiggroup.recrutamento.taskmanager.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.tarefa.TarefaInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.enums.StatusTarefa;
import br.com.esiggroup.recrutamento.taskmanager.models.Responsavel;
import br.com.esiggroup.recrutamento.taskmanager.models.Tarefa;
import br.com.esiggroup.recrutamento.taskmanager.repositories.TarefaRepository;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.ResponsavelService;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.TarefaService;
import br.com.esiggroup.recrutamento.taskmanager.utils.DateParser;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TarefaServiceImpl implements TarefaService {

	private final TarefaRepository repository;

	private final ResponsavelService responService;

	@Override
	@Transactional(readOnly = true)
	public List<TarefaDto> findAll() {
		ModelMapper mapper = new ModelMapper();
		List<TarefaDto> tarefas = new ArrayList<>();
		repository.findAll().forEach(t -> {
			TarefaDto tarefa = mapper.map(t, TarefaDto.class);
			tarefa.setDeadlineTarefa(new DateParser().formatDate(t.getDeadlineTarefa()));
			tarefas.add(tarefa);
		});
		if (tarefas.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		return tarefas;
	}

	@Override
	@Transactional
	public TarefaDto save(TarefaInsertDto dto) {
		ModelMapper mapper = new ModelMapper();
		responService.verifyResponsavel(dto.getResponsavelTarefa().getIdResponsavel());

		Responsavel responsavel = mapper.map(dto.getResponsavelTarefa(), Responsavel.class);

		Tarefa tarefa = mapper.map(dto, Tarefa.class);
		tarefa.setStatusTarefa(StatusTarefa.Pendente);
		tarefa.setDeadlineTarefa(new DateParser().parse(dto.getDeadlineTarefa()));
		tarefa.setResponsavelTarefa(responsavel);
		tarefa = repository.save(tarefa);

		TarefaDto dtoResponse = mapper.map(tarefa, TarefaDto.class);
		ResponsavelDto resDto = mapper.map(tarefa.getResponsavelTarefa(), ResponsavelDto.class);
		dtoResponse.setResponsavelTarefa(resDto);
		dtoResponse.setDeadlineTarefa(new DateParser().formatDate(tarefa.getDeadlineTarefa()));
		
		return dtoResponse;
	}
}
