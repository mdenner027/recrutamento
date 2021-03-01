package br.com.esiggroup.recrutamento.taskmanager.services.implementations;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.esiggroup.recrutamento.taskmanager.configurations.jwt.JwtTokenUtil;
import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtRequest;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtResponse;
import br.com.esiggroup.recrutamento.taskmanager.services.JwtUserDetailsService;
import br.com.esiggroup.recrutamento.taskmanager.services.interfaces.LoginService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpImpl implements LoginService {

	private final AuthenticationManager authenticationManager;

	private final JwtTokenUtil jwtTokenUtil;

	private final JwtUserDetailsService userDetailsService;

	@Override
	public UsuarioDto save(UsuarioDto dto) {
		return userDetailsService.save(dto);
	}

	@Override
	public JwtResponse login(JwtRequest request) {
		try {
			authenticate(request.getLoginUsuario(), request.getSenhaUsuario());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLoginUsuario());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return new JwtResponse(token);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
