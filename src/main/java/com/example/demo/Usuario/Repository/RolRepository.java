package com.example.demo.Usuario.Repository;

import java.util.List;

import com.example.demo.Usuario.Entity.Rol;
import com.example.demo.Usuario.Model.RolModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Long> {


	// @Query(value = "SELECT new com.Model.RolModel (r.id AS id, "
	// 		+ " r.name AS name ) "
	// 		+ " FROM Rol r INNER JOIN Usuario u ON   r.id = u.rol.id")
	// List<RolModel> getAllRol();
}
