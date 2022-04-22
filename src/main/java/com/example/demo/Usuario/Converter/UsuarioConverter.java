package com.example.demo.Usuario.Converter;

import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Model.UsuarioModel;
import com.example.demo.Usuario.Repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("usuarioConverter")
public class UsuarioConverter {
    @Autowired
    @Qualifier("rolRepository")
    private RolRepository rolRepository;


    public UsuarioModel entityToModel(Usuario usuario) {
        UsuarioModel user = new UsuarioModel();
            if(usuario!=null){
                user.setId(usuario.getId());
                user.setUsername(usuario.getUsername());
                user.setName(usuario.getName());
                user.setPassword(usuario.getPassword());
                user.setRol(usuario.getRol());

            }
        return user;
    }

    public Usuario modelToEntity(UsuarioModel usuario) {
        Usuario user = new Usuario();
            if(usuario!=null){
                user.setId(usuario.getId());
                user.setUsername(usuario.getUsername());
                user.setName(usuario.getName());
                user.setPassword(usuario.getPassword());

                user.setRol(usuario.getRol());
                // user.setRol(usuario.getRol();

            }
        return user;
    }
}
