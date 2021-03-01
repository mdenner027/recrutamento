package br.com.esiggroup.recrutamento.taskmanager.dtos.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioInsertDto {
	private String loginUsuario;
	private String senhaUsuario;
}
