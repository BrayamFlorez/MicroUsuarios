package com.example.demo.Usuario.Converter;

import com.example.demo.Usuario.Entity.Rol;
import com.example.demo.Usuario.Model.RolModel;

import org.springframework.stereotype.Component;

@Component("rolConverter")
public class RolConverter {
    

    public RolModel entityToModel(Rol rol) {
        RolModel rolModel = new RolModel();
            if(rol!=null){
                rolModel.setId(rol.getId());
                rolModel.setName(rol.getName());
                // user.setRol(usuario.getRol();

            }
        return rolModel;
    }

    public Rol modelToEntity(RolModel rolModel) {
        Rol rol = new Rol();
            if(rolModel!=null){
                rol.setId(rol.getId());
                rol.setName(rol.getName());
                // user.setRol(usuario.getRol();

            }
        return rol;
    }

   
}
