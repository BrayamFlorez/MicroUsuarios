package com.example.demo.Usuario.Repository;

import java.util.List;

import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Model.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// @Query(value = "SELECT new com.Model.UsuarioModel (u.id AS id, "
	// 		+ " u.username AS username, u.password AS password,  "
	// 		+ " r.name AS nombreRol ) "
	// 		+ " FROM Usuario u INNER JOIN Rol r ON u.rol.id = r.id"
	// 		+ " WHERE u.username = :username ")
	// UsuarioModel findByUsuarioUsername(String username);

	// @Query(value = "SELECT new com.Model.UsuarioModel (u.id AS id, "
	// + " u.username AS username, u.password AS password,  "
	// + " r.name AS nombreRol ) "
	// + " FROM Usuario u INNER JOIN Rol r ON u.rol.id = r.id"
	// 		+ " WHERE u.username = :username "
	// 		+ " AND SUBSTR(u.password,7) = :password")
	// UsuarioModel findByUsuarioUsernamePassword(String username, String password);


	@Query(value = "SELECT new com.example.demo.Usuario.Model.UsuarioModel ( "
	+ " u.username AS username) "
	+ " FROM Usuario u INNER JOIN Rol r ON u.rol = r.id")
	List<UsuarioModel> getAllUsuarios();
}
