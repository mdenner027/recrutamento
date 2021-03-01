package br.com.esiggroup.recrutamento.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.esiggroup.recrutamento.taskmanager.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByLoginUsuario(String login);
}
