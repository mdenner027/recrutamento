package br.com.esiggroup.recrutamento.taskmanager.services.interfaces;

import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtRequest;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtResponse;

public interface LoginService {
	UsuarioDto save(UsuarioDto dto);
	
	JwtResponse login(JwtRequest request);
}
