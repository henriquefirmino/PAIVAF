package com.paaf.test.java.com.paaf;

import javax.persistence.EntityManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.paaf.model.CategoriaProduto;

public class ControleEstoqueApplicationTest {
    
    @Autowired
	private EntityManager testEntityManager;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void whenFindById_thenReturnProduto() {
		
		CategoriaProduto cereais = new CategoriaProduto();
		cereais.setNome("Cereais");
		cereais.setDescricao("Grãos e sementes");
		
		testEntityManager.persist(cereais);
		testEntityManager.flush();
	}
    
}
