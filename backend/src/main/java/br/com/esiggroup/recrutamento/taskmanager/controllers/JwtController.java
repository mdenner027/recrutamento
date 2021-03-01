package br.com.esiggroup.recrutamento.taskmanager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.esiggroup.recrutamento.taskmanager.configurations.jwt.JwtTokenUtil;
import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioDto;
import br.com.esiggroup.recrutamento.taskmanager.dtos.usuario.UsuarioInsertDto;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtRequest;
import br.com.esiggroup.recrutamento.taskmanager.models.JwtResponse;
import br.com.esiggroup.recrutamento.taskmanager.services.JwtUserDetailsService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class JwtController {

	private final AuthenticationManager authenticationManager;

	private final JwtTokenUtil jwtTokenUtil;

	private final JwtUserDetailsService userDetailsService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<UsuarioDto> saveUser(@RequestBody UsuarioInsertDto user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
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
