package com.grupo9.vecinal.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo9.vecinal.Servicios.UsuarioServicio;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioServ;

	@PostMapping("/registro")
	public String registro(ModelMap modelo,@RequestParam String nombreUsuario, @RequestParam String contrasenia,
			@RequestParam String contrasenia2, @RequestParam String emailUsuario, @RequestParam String nombre,
			@RequestParam String apellido, @RequestParam Integer telefono) {
		usuarioServ.crearUsuario(nombreUsuario, contrasenia, contrasenia2, emailUsuario, nombre, apellido, telefono);
		try {
			return "usuarios.html";
		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "redirect:/usuarios/registro";
		}
		
	}
}