package com.example.demo.Service;

import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);

    }

    @Override
    public void deleteProduit(Produit produit) {
        produitRepository.delete(produit);

    }

    @Override
    public void deleteProduitById(Long id) {

    }

    @Override
    public Produit getProduit(Long id) {
        return null;
    }

    @Override
    public List<Produit> getAllProduits() {
        return null;
    }
}
