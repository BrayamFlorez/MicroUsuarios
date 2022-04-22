package com.example.demo.Usuario.Service;

import java.util.List;

import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Model.UsuarioModel;

public interface UsuarioService {
    
    // public abstract UsuarioModel getUsusarioUsername(String username);

    public abstract List<UsuarioModel> getUsuarios();

    public abstract UsuarioModel crearUsuario(UsuarioModel usuario);

    public abstract boolean deleteUsuario(Long id);

    // public abstract UsuarioModel getUsusarioUsernamePassword(String username, String password);

	
	// public abstract UsuarioModel getUsuarioIdUsuarioEmpresaUsuario(long idUsuario);
}
