package com.paaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/home")
public class HomeController {

	@GetMapping({"/", "/home"})
	public ModelAndView home() {
		ModelAndView model = new  ModelAndView("/homepage");
		model.addObject("mensagem", "Controle de Estoques. Página Inicial.");
		
		return model;
	}
	
}
