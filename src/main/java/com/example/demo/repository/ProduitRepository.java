package com.example.demo.repository;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // Utilisation des structures internes à Spring, la fonction doit être au format findBy suivi du nom exact de la variable appellée dans la classe visée
    List<Produit> findByNomProduit(String nom);
    // La valeur contains permet d'afficher toutes les valeurs contenant la recherche
    List<Produit> findByNomProduitContains(String nom);

    // Utilisation du langage JPQL pour des requêtes personnalisées manuellement vers la base de données
    /*@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
    List<Produit> findByNomPrix(String nom, Double prix);*/

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix(@Param("nom") String nom,@Param("prix") Double prix);


    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);

    List<Produit> findByCategorieIdCategorie(Long id);

    //Trier les données selon leur nom
    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit DESC, p.prixProduit ASC")
    List<Produit> trierProduitsNomsPrix ();
}
