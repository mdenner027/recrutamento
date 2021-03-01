package br.com.esiggroup.recrutamento.taskmanager.services.interfaces;

import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;

public interface UsuarioService {
	UsuarioDto save(UsuarioDto dto);

	UsuarioDto findByLogin(String login);

	UsuarioDto findByLoginAndSenha(String login, String senha);
}
