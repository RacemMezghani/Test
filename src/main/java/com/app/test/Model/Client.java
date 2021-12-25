package com.app.test.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends User {


    private String adresse;
    private String ville;
    private Long codePostal;
    private String tel;
    private String fax;
    private String gsm;

    @Builder
    public Client(String code, String nom, String prenom, String email, LocalDate dateNaissance,
                  String adresse, String ville, Long codePostal, String tel, String fax, String gsm) {
        super(code,nom,prenom,email,dateNaissance);
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.tel = tel;
        this.fax = fax;
        this.gsm = gsm;
    }
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Commande> commandes;
}
