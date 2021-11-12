package com.grupo9.vecinal.Controladores;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grupo9.vecinal.Entidades.Usuario;

@Controller
@RequestMapping("/")
public class IndexControlador {

	@GetMapping("/")
	public String index() {
		return "index.html";
	}

	@GetMapping("/login")
	public String login(HttpSession session, ModelMap modelo, @RequestParam(required = false) String error) {

		if (session.getAttribute("usuariologueado") != null) {
			return "redirect:/";
		}
		if (error != null) {
			modelo.put("error", "Usuario o contraseña incorrectas");
		}
		return "login.html";
	}

	@GetMapping("/default")
	public String roles(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuariologueado");
		if (usuario.getAdmin()) {
			return "redirect:/usuarios/bajaUsuario";
		} else {
			return "redirect:/usuarios/inscripcion";
		}
	}

}
