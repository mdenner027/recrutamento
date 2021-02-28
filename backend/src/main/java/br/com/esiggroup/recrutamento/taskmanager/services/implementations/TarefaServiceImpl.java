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

	@Override
	@Transactional
	public TarefaDto complete(Long idTarefa) {
		verifyTarefa(idTarefa);
		Tarefa tarefa = repository.getOne(idTarefa);
		tarefa.setStatusTarefa(StatusTarefa.Concluída);
		tarefa = repository.save(tarefa);
		TarefaDto dtoResponse = new ModelMapper().map(tarefa, TarefaDto.class);
		dtoResponse.setDeadlineTarefa(new DateParser().formatDate(tarefa.getDeadlineTarefa()));
		return dtoResponse;
	}

	@Override
	@Transactional
	public void delete(Long idTarefa) {
		verifyTarefa(idTarefa);
		Tarefa tarefa = repository.findByIdTarefa(idTarefa);
		repository.delete(tarefa);
	}

	@Override
	@Transactional(readOnly = true)
	public TarefaDto findById(Long idTarefa) {
		verifyTarefa(idTarefa);
		ModelMapper mapper = new ModelMapper();
		Tarefa tarefa = repository.findByIdTarefa(idTarefa);
		TarefaDto dtoResponse = mapper.map(tarefa, TarefaDto.class);
		dtoResponse.setDeadlineTarefa(new DateParser().formatDate(tarefa.getDeadlineTarefa()));
		return dtoResponse;
	}

	@Override
	@Transactional
	public TarefaDto update(TarefaDto dto) {
		verifyTarefa(dto.getIdTarefa());
		ModelMapper mapper = new ModelMapper();
		Responsavel responsavel = mapper.map(dto.getResponsavelTarefa(), Responsavel.class);

		Tarefa tarefa = mapper.map(dto, Tarefa.class);
		tarefa.setResponsavelTarefa(responsavel);
		tarefa.setDeadlineTarefa(new DateParser().parse(dto.getDeadlineTarefa()));
		tarefa = repository.save(tarefa);

		TarefaDto dtoResponse = mapper.map(tarefa, TarefaDto.class);
		dtoResponse.setDeadlineTarefa(new DateParser().formatDate(tarefa.getDeadlineTarefa()));
		dtoResponse.setResponsavelTarefa(mapper.map(tarefa.getResponsavelTarefa(), ResponsavelDto.class));

		return dtoResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TarefaDto> filter(Long idTarefa, String tituloDescricao, StatusTarefa status, Long idResponsavel) {
		ModelMapper mapper = new ModelMapper();
		List<Tarefa> tarefas = repository.findAll();

		if (idResponsavel != null) {
			tarefas = filterByResponsavel(idResponsavel, tarefas);
		}

		if (!tituloDescricao.isEmpty() && !tituloDescricao.isBlank()) {
			tarefas = filterByTituloOuDescricao(tituloDescricao, tarefas);
		}

		if (status != null) {
			tarefas = filterByStatus(status, tarefas);
		}

		if (idTarefa != null) {
			tarefas = filterByIdTarefa(idTarefa, tarefas);
		}

		List<TarefaDto> listResponse = new ArrayList<>();

		tarefas.forEach(t -> {
			TarefaDto tarefa = mapper.map(t, TarefaDto.class);
			tarefa.setDeadlineTarefa(new DateParser().formatDate(t.getDeadlineTarefa()));
			listResponse.add(tarefa);
		});

		if (listResponse.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT,
					"Nenhum registro econtado com essas especificações");
		}
		return listResponse;
	}

	private List<Tarefa> filterByIdTarefa(Long idTarefa, List<Tarefa> tarefas) {
		tarefas.removeIf(t -> t.getIdTarefa() != idTarefa);
		return tarefas;
	}

	private List<Tarefa> filterByResponsavel(Long idResponsavel, List<Tarefa> tarefas) {
		tarefas.removeIf(t -> t.getResponsavelTarefa().getIdResponsavel() != idResponsavel);
		return tarefas;
	}

	private List<Tarefa> filterByTituloOuDescricao(String filtro, List<Tarefa> tarefas) {
		tarefas.removeIf(t -> !(t.getTituloTarefa().startsWith(filtro) || t.getDescricaoTarefa().startsWith(filtro)));
		return tarefas;
	}

	private List<Tarefa> filterByStatus(StatusTarefa status, List<Tarefa> tarefas) {
		tarefas.removeIf(t -> t.getStatusTarefa() != status);
		return tarefas;
	}

	private void verifyTarefa(Long idTarefa) {
		if (repository.findByIdTarefa(idTarefa) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Nenhuma tarefa encontrada com o identificador informado: " + idTarefa);
		}
	}
}
