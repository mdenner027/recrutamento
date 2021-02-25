package br.com.esiggroup.recrutamento.taskmanager.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return responsaveis;
	}

	@Override
	@Transactional(readOnly = true)
	public ResponsavelDto findById(Long idResponsavel) {
		ModelMapper mapper = new ModelMapper();
		Responsavel responsavel = repository.findByIdResponsavel(idResponsavel);
		return responsavel == null ? null : mapper.map(responsavel, ResponsavelDto.class);
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
		Responsavel responsavel = repository.findByIdResponsavel(idResponsavel);
		if (responsavel != null) {
			repository.delete(responsavel);
		}
	}

	@Override
	public Boolean existResponsavel(Long idResponsavel) {
		if (repository.findByIdResponsavel(idResponsavel) == null) {
			return false;
		} else {
			return true;
		}
	}
}
