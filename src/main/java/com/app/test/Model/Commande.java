package com.app.test.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commande implements Serializable {
    @Id
    private String numero;
    private LocalDate date;
    private BigDecimal prixTotal;
    private Long etat;

    public Commande(String numero, LocalDate date, Long etat) {
        this.numero = numero;
        this.date = date;
        this.etat = etat;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "client_code", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "commande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LigneCommande> ligneCommandes;
}
