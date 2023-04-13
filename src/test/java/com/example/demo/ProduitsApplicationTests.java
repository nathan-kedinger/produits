package com.example.demo;

import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Test
	public void testCreateProduit() {
		Produit produit = new Produit("PC Asus",1500.500,new Date());
		produitRepository.save(produit);
	}

	@Test
	public void testFindProduit()
	{
		Produit produit = produitRepository.findById(1L).get();
		System.out.println(produit);
	}
	@Test
	public void testUpdateProduit()
	{
		Produit produit = produitRepository.findById(1L).get();
		produit.setPrixProduit(1000.0);
		produitRepository.save(produit);
	}

	@Test
	public void testDeleteProduit()
	{
		produitRepository.deleteById(1L);;
	}
	@Test
	public void testListerTousProduits()
	{
		List<Produit> produits = produitRepository.findAll();
		for (Produit produit : produits)
		{
			System.out.println(produit);
		}
	}

}
