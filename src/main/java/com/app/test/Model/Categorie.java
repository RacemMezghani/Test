package com.app.test.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie implements Serializable {

    @Id
    private String code;
    private String libelle;

    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Produit> produits;
}
