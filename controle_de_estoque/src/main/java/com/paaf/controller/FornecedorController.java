package com.paaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.paaf.exception.Excecao;
import com.paaf.model.Fornecedor;
import com.paaf.service.FornecedorService;

@Controller("/fornecedor")
public class FornecedorController {
	
	@Autowired
	FornecedorService fornecedorService;

	@GetMapping("/fornecedores/listar")
	public String listarFornecedores(Model model) {
		
		List<Fornecedor> fornecedores = fornecedorService.getListaFornecedores();
		model.addAttribute("fornecedores", fornecedores);
		
		return "/fornecedor/exibirFornecedores";
	}
	
	@GetMapping("/fornecedores/adicionarFornecedor")
	public String adicionarFornecedor(Model model) {
		
		Fornecedor fornecedor = new Fornecedor();
		model.addAttribute("fornecedor", fornecedor);
		
		List<String> listaCidades = this.getListaCidades();
		model.addAttribute("listaCidades", listaCidades);
		
		return "/fornecedor/incluirFornecedor";
	}
	
	private List<String> getListaCidades() {
		List<String> listaCidades = new ArrayList<>();
		listaCidades.add("Manaus");
		listaCidades.add("Rio de Janeiro");
		listaCidades.add("São Paulo");
		
		return listaCidades;
	}

	@PostMapping("/fornecedores/salvarFornecedor")
	public String salvarFornecedor(@ModelAttribute("fornecedor") Fornecedor fornecedor) {
		
		fornecedorService.salvarFornecedor(fornecedor);
		return "redirect:/fornecedores/listar";
	}
	
	@GetMapping("/fornecedores/editarFornecedor/{id}")
	public String editarFornecedor(@ModelAttribute("id") ObjectId id, Model model) throws Excecao {
		
		Fornecedor fornecedor = fornecedorService.getFornecedor(id);
		model.addAttribute("fornecedor", fornecedor);
		
		List<String> listaCidades = this.getListaCidades();
		model.addAttribute("listaCidades", listaCidades);

		return "/fornecedor/editarFornecedor";
	}
	
	@GetMapping("/fornecedores/removerFornecedor/{id}")
	public String removerFornecedor(@ModelAttribute("id") ObjectId id) throws Excecao {
		
		fornecedorService.removerFornecedor(id);
		return "redirect:/fornecedores/listar";
	}
	
}
