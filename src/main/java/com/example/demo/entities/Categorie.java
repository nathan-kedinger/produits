package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idCategorie;
    private String nameCategorie;
    private String descriptionCategorie;
    @OneToMany(mappedBy = "categorie")
    @JsonIgnore //empeche de retourner la liste de produit pour éviter une boucle infinie
    private List<Produit> produits;
}
