package br.com.esiggroup.recrutamento.taskmanager.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.responsavel.ResponsavelInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.models.Responsavel;
import br.com.esiggroup.recrutamento.taskmanager.repositories.ResponsavelRepository;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.ResponsavelService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResponsavelServiceImpl implements ResponsavelService {
	private final ResponsavelRepository repository;
	
	@Override
	@Transactional
	public ResponsavelDto save(ResponsavelInsertDto dto) {
		ModelMapper mapper = new ModelMapper();
		Responsavel resp = repository.save(mapper.map(dto, Responsavel.class));
		return mapper.map(resp, ResponsavelDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResponsavelDto> findAll() {
		List<ResponsavelDto> responsaveis = new ArrayList<>();
		ModelMapper mapper = new ModelMapper();
		repository.findAll().forEach(responsavel -> {
			responsaveis.add(mapper.map(responsavel, ResponsavelDto.class));
		});
		if (responsaveis.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT);
		}
		return responsaveis;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponsavelDto findById(Long idResponsavel) {
		verifyResponsavel(idResponsavel);
		ModelMapper mapper = new ModelMapper();
		Responsavel responsavel = repository.findByIdResponsavel(idResponsavel);
		return mapper.map(responsavel, ResponsavelDto.class);
	}

	@Override
	@Transactional
	public ResponsavelDto update(ResponsavelDto dto) {
		ModelMapper mapper = new ModelMapper();
		Responsavel resp = mapper.map(dto, Responsavel.class);
		resp = repository.save(resp);
		return mapper.map(resp, ResponsavelDto.class);
	}

	@Override
	@Transactional
	public void delete(Long idResponsavel) {
		verifyResponsavel(idResponsavel);
		Responsavel responsavel = repository.findByIdResponsavel(idResponsavel);
		repository.delete(responsavel);
	}

	@Override
	@Transactional(readOnly = true)
	public void verifyResponsavel(Long idResponsavel) {
		if (repository.findByIdResponsavel(idResponsavel) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Nenhum registro encontrado com o identificador informado: " + idResponsavel);
		}
	}
}
