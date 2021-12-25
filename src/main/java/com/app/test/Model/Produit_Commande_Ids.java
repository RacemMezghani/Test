package com.app.test.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class Produit_Commande_Ids implements Serializable {
    private String produit_code;
    private String commande_numero;

    public Produit_Commande_Ids(String produit_code, String commande_numero) {
        this.produit_code = produit_code;
        this.commande_numero = commande_numero;
    }
}
