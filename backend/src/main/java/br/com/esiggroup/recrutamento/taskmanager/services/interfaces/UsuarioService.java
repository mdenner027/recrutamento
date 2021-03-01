package br.com.esiggroup.recrutamento.taskmanager.services.interfaces;

import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioInsertDto;

public interface UsuarioService {
	UsuarioDto save(UsuarioInsertDto dto);

	UsuarioDto findByLogin(String login);

	UsuarioDto findByLoginAndSenha(String login, String senha);
}
