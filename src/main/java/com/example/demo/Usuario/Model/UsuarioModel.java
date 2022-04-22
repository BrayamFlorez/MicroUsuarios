package com.example.demo.Usuario.Model;

import com.example.demo.Usuario.Entity.Rol;

public class UsuarioModel {
    
    private Long id;
    private String name;
    private String username;
    private String password;
    private Rol rol;
    private Long idRol;

    public UsuarioModel(){}

    
    public UsuarioModel(String username) {
        this.username = username;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Rol getRol() {
        return rol;
    }


    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public Long getIdRol() {
        return idRol;
    }


    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

 
  
    
    
}
