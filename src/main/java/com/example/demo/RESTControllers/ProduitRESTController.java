package com.example.demo.RESTControllers;

import com.example.demo.Service.ProduitService;
import com.example.demo.entities.Produit;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")// crée une route
@CrossOrigin //Tout le monde peut acceder
public class ProduitRESTController {
    @Autowired
    ProduitService produitService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Produit updateProduit(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id) {
         produitService.deleteProduitById(id);
    }

    @RequestMapping(value="/produitCategorie/{idCategorie}", method = RequestMethod.GET)
    public List<Produit> getProduitsByCategorieId(@PathVariable("idCategorie") Long idCategorie) {
        return produitService.findByCategorieIdCat(idCategorie);
    }

}
