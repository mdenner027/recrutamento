package br.com.esiggroup.recrutamento.taskmanager.services.implementations;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;
import br.com.esiggroup.recrutamento.taskmanager.models.Usuario;
import br.com.esiggroup.recrutamento.taskmanager.repositories.UsuarioRepository;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
	private final UsuarioRepository repository;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public UsuarioDto save(UsuarioDto dto) {
		ModelMapper mapper = new ModelMapper();
		Usuario user = new Usuario();
		user.setLoginUsuario(dto.getLoginUsuario());
		user.setSenhaUsuario(passwordEncoder.encode(dto.getSenhaUsuario()));
		user = repository.save(user);
		return mapper.map(user, UsuarioDto.class);
	}

	@Override
	public UsuarioDto findByLogin(String login) {
		ModelMapper mapper = new ModelMapper();
		Usuario user = repository.findByLoginUsuario(login);
		return mapper.map(user, UsuarioDto.class);
	}

	@Override
	public UsuarioDto findByLoginAndSenha(String login, String senha) {
		ModelMapper mapper = new ModelMapper();
		Usuario user = repository.findByLoginUsuario(login);
		if(user != null) {
			if(passwordEncoder.matches(senha, user.getSenhaUsuario())) {
				return mapper.map(user, UsuarioDto.class);
			}
		}
		return null;
	}
}
