package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import com.example.demo.Usuario.Model.UsuarioModel;
import com.example.demo.Usuario.ServiceImpl.UsuarioServiceImpl;
import com.google.gson.Gson;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	public static Log LOG = LogFactory.getLog(UsuarioController.class);
	public static Gson gson = new Gson();
	
	UsuarioModel u = new UsuarioModel();
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioServiceImpl usuarioService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<UsuarioModel>> getAllReHospitalario() {
		List<UsuarioModel> listaReHoModelReturn = null;
		try {
			listaReHoModelReturn = usuarioService.getUsuarios();
			return new ResponseEntity<>(listaReHoModelReturn, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.info(" Error : " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@RequestMapping(value = "/users/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UsuarioModel> addUsuario(@RequestBody UsuarioModel user) {
		HashMap<String, String> msg = new HashMap<>();
		UsuarioModel usuarioModel = null;
		LOG.info("ESTA ENTRANDO AL CONTROLLER DE RESIDUOS PROFESIONALES");
		try {
			
			usuarioModel = usuarioService.crearUsuario(user);
			
			return new ResponseEntity<>(usuarioModel, HttpStatus.OK);
		} catch (HibernateException e) {
			LOG.error("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/users/eliminar/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteUsuario(@PathVariable long id) {
		boolean resultado =false;
        try {
			resultado=usuarioService.deleteUsuario(id);
			
			
        } catch (HibernateException e) {
            LOG.error(" Error : " + e.getMessage());
        }
        return resultado;
	}






	@RequestMapping(value ="prueba")
	public String prueba(){

		return "asdasdasd";
	}

}
