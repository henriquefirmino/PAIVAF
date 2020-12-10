package com.paaf.controller;

import java.util.List;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paaf.exception.Excecao;
import com.paaf.model.CategoriaProduto;
import com.paaf.model.Estoque;
import com.paaf.model.Fornecedor;
import com.paaf.model.Produto;
import com.paaf.service.CategoriaProdutoService;
import com.paaf.service.FornecedorService;
import com.paaf.service.ProdutoService;

@Controller
@RequestMapping("/")
public class ProdutoController {

	@Autowired private ProdutoService produtoService;
	@Autowired private CategoriaProdutoService categoriaProdutoSercice;
	@Autowired private FornecedorService fornecedorService;

	@GetMapping("/produtos/listar")
	public ModelAndView listarProdutos() {

		ModelAndView model = new ModelAndView("/produto/exibirProdutos");
		List<Produto> listaProdutos = produtoService.getListaProdutos();
		model.addObject("listaProdutos", listaProdutos);

		return model;
	}
	
	@GetMapping("/produtos/detalhar/{id}")
	public ModelAndView detalharProduto(@PathVariable("id") ObjectId id) throws Excecao {
		
		Produto produto = produtoService.getProduto(id);
		
		ModelAndView model = new ModelAndView("/produto/detalharProduto");
		model.addObject("produto", produto);
		
		return model;
	}
	
	@GetMapping("/produtos/adicionarProduto")
	public ModelAndView exibirInclusaoProduto(Produto produto) {
		
		ModelAndView model = new ModelAndView("/produto/incluirProduto");
		model.addObject("produto", produto);
		
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addObject("listaCategorias", listaCategorias);
		
		List<Fornecedor> listaFornecedores = fornecedorService.getListaFornecedores();
		model.addObject("listaFornecedores", listaFornecedores);
		
		return model;
	}

	@GetMapping("/produtos/editarProduto")
	public ModelAndView exibirAlteracaoProduto(Produto produto) {
		
		ModelAndView model = new ModelAndView("/produto/alterarProduto");
		model.addObject("produto", produto);
		
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addObject("listaCategorias", listaCategorias);
		
		List<Fornecedor> listaFornecedores = fornecedorService.getListaFornecedores();
		model.addObject("listaFornecedores", listaFornecedores);

		return model;
	}
	
	@PostMapping("/produtos/salvarProduto")
	public ModelAndView salvarProduto(@ModelAttribute("produto") Produto produto) {

		if(produto.getEstoque() == null) {
			Estoque e = new Estoque();
			e.setLote(UUID.randomUUID().toString());
			e.setQuantidade(0);

			produto.setEstoque(e);
		}
		
		produtoService.salvarProduto(produto);
		return new ModelAndView("redirect:/produtos/listar");
	}

	@GetMapping("/produtos/alterarProduto/{id}")
	public ModelAndView alterarProduto(@PathVariable("id") ObjectId id) throws Excecao {

		Produto produto = produtoService.getProduto(id);
		return exibirAlteracaoProduto(produto);
	}

	@GetMapping("/produtos/deletarProduto/{id}")
	public ModelAndView deletarProduto(@PathVariable("id") ObjectId id) throws Excecao {

		produtoService.removerProduto(id);
		return new ModelAndView("redirect:/produtos/listar");
	}
	
	@GetMapping("/categorias/listar")
	public String listarCategorias(Model model) {
		List<CategoriaProduto> listaCategorias = categoriaProdutoSercice.getListaCategorias();
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "/categoria/exibirCategorias";
	}
	
	@GetMapping("/categorias/adicionarCategoria")
	public String exibirFormAdicionarCategoria(Model model) {

		CategoriaProduto categoriaProduto = new CategoriaProduto();
		model.addAttribute("categoria", categoriaProduto);
		
		return "/categoria/incluirCategoria";
	}
	
	@PostMapping("/categorias/salvarCategoria")
	public String salvarCategoria(@ModelAttribute("categoria") CategoriaProduto categoriaProduto) {
		categoriaProdutoSercice.salvarCategoria(categoriaProduto);
		return "redirect:/categorias/listar";
	}
	
	@GetMapping("/categorias/alterarCategoria/{id}")
	public String exibirFormAlterarCategoria(@ModelAttribute("id") ObjectId id, Model model) throws Excecao {
		CategoriaProduto categoriaProduto = categoriaProdutoSercice.getCategoria(id);
		model.addAttribute("categoria", categoriaProduto);
		
		return "/categoria/editarCategoria";
	}
	
	@GetMapping("/categorias/removerCategoria/{id}")
	public String deletarCategoria(@ModelAttribute("id") ObjectId id) throws Excecao {
		categoriaProdutoSercice.removerCategoria(id);
		return "redirect:/categorias/listar";
	}
}
