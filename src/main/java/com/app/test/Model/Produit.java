package com.app.test.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produit implements Serializable {
    @Id
    private String code;
    private String marque;
    private String modele;
    private String caracteristiques;
    private BigDecimal prixUnitaire;
    private Long quantite;

    public Produit(String code, String marque, String modele, String caracteristiques, BigDecimal prixUnitaire, Long quantite) {
        this.code = code;
        this.marque = marque;
        this.modele = modele;
        this.caracteristiques = caracteristiques;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    //@JoinColumn(name = "categorie_code", nullable = false)
    private Categorie categorie;


    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LigneCommande> ligneCommandes;


}
