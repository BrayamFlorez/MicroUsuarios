package com.example.demo.Usuario.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Usuario.Converter.RolConverter;
import com.example.demo.Usuario.Converter.UsuarioConverter;
import com.example.demo.Usuario.Entity.Usuario;
import com.example.demo.Usuario.Model.RolModel;
import com.example.demo.Usuario.Model.UsuarioModel;
import com.example.demo.Usuario.Repository.RolRepository;
import com.example.demo.Usuario.Repository.UsuarioRepository;
import com.example.demo.Usuario.Service.UsuarioService;

import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Qualifier("rolRepository")
    private RolRepository rolRepository;

    @Autowired
    @Qualifier("rolConverter")
    private RolConverter rolConverter;

    @Autowired
    @Qualifier("usuarioConverter")
    private UsuarioConverter usuarioConverter;

    @Override
    public UsuarioModel crearUsuario(UsuarioModel usuarioModel) {

        UsuarioModel user = null;
        try {

            usuarioModel.setRol(rolRepository.getById(usuarioModel.getIdRol()));

            Usuario residuo = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));
           

            user = usuarioConverter.entityToModel(residuo);
        } catch (SQLGrammarException e) {
            System.out.println(e);
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        return user;
    }

    // @Override
    // public UsuarioModel getUsusarioUsernamePassword(String username, String
    // password) {
    // UsuarioModel user = usuarioRepository.findByUsuarioUsernamePassword(username,
    // password);
    // return user;

    // }

    // @Override
    // public List<Usuario> getUsuarios() {
    // List<Usuario> lista = usuarioRepository.findAll();

    // // for(Usuario u : lista2){
    // // lista.add(usuarioConverter.entityToModel(u));

    // // }

    // return lista;
    // }

    @Override
    public List<UsuarioModel> getUsuarios() {
        List<Usuario> listadoUser = usuarioRepository.findAll();
        List<UsuarioModel> lista = new ArrayList<>();

        for (Usuario u : listadoUser) {
            lista.add(usuarioConverter.entityToModel(u));

        }

        return lista;
    }

    @Override
    public boolean deleteUsuario(Long id) {
        boolean resultado =false;
        try {
                 usuarioRepository.deleteById(id);  
                 resultado=true;
        } catch (Exception e) {
            //TODO: handle exception
        }
         return resultado;
    }

    // @Override
    // public UsuarioModel getUsusarioUsername(String username) {
    // UsuarioModel user = usuarioRepository.findByUsuarioUsername(username);
    // return user;
    // }

}
