package br.com.esiggroup.recrutamento.taskmanager.services;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.models.Usuario;
import br.com.esiggroup.recrutamento.taskmanager.repositories.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = repository.findByLoginUsuario(username);

		if (user != null) {
			return new User(user.getLoginUsuario(), user.getSenhaUsuario(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Login não encontrado: " + username);
		}
	}

	public UsuarioDto save(UsuarioInsertDto dto) {
		Usuario usuario = new Usuario();
		usuario.setLoginUsuario(dto.getLoginUsuario());
		usuario.setSenhaUsuario(passwordEncoder.encode(dto.getSenhaUsuario()));
		usuario = repository.save(usuario);
		return new ModelMapper().map(usuario, UsuarioDto.class);
	}
}
