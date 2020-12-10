package com.paaf.controller;

import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paaf.exception.Excecao;
import com.paaf.model.Estoque;
import com.paaf.service.EstoqueService;

@Controller
public class InventarioController {

	@Autowired
	private EstoqueService estoqueService;

	@RequestMapping(value = "/inventarios/listar", method = RequestMethod.GET)
	public ModelAndView listarestoques() {
		List<Estoque> listaestoques = estoqueService.getListaEstoques();
		
		ModelAndView model = new ModelAndView("/inventario/exibirEstoques");
		model.addObject("listaEstoques", listaestoques);
		
		return model;
	}
	
	@RequestMapping(value = "/inventarios/alterarEstoque")
	public ModelAndView exibirAlteracaoEstoque(Estoque estoque) {
		
		ModelAndView model = new ModelAndView("/inventario/editarEstoque");
		model.addObject("estoque", estoque);
		
		return model;
	}
	
	@RequestMapping(value = "/inventarios/salvarEstoque", method = RequestMethod.POST)
	public ModelAndView salvarEstoque(@ModelAttribute("estoque") Estoque estoque) {
		
		estoqueService.salvarEstoque(estoque);
		return new ModelAndView("redirect:/produtos/listar");
	}
	
	@RequestMapping(value = "/inventarios/editarEstoque/{id}", method = RequestMethod.GET)
	public ModelAndView editarEstoque(@PathVariable("id") ObjectId id) 
					throws Excecao {
		Estoque estoque = estoqueService.getEstoque(id);
		
		if(estoque.getLote() == null) {
			estoque.setLote(UUID.randomUUID().toString());
		}
		
		return exibirAlteracaoEstoque(estoque);
	}
	
	@RequestMapping(value = "/inventarios/removerEstoque/{id}", method = RequestMethod.GET)
	public ModelAndView removerEstoque(@PathVariable("id") ObjectId id) throws Excecao {

		estoqueService.removerEstoque(id);
		return new ModelAndView("redirect:/inventarios/listar");
	}
	
}
