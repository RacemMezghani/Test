package com.app.test.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LigneCommande implements Serializable {
    @EmbeddedId
    private Produit_Commande_Ids id;
    private Long qte;
    private BigDecimal prixUnitaire;
    private BigDecimal prixTotal;
    private Long etat;

    public LigneCommande(Produit_Commande_Ids id, Long qte, BigDecimal prixUnitaire, Long etat) {
        this.id = id;
        this.qte = qte;
        this.prixUnitaire = prixUnitaire;
        this.prixTotal = this.prixUnitaire.multiply(BigDecimal.valueOf(this.qte));
        this.etat = etat;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("commande_numero")
    @JsonBackReference
    private Commande commande;
    @ManyToOne
    @MapsId("produit_code")
    @JsonBackReference
    private Produit produit;
}
