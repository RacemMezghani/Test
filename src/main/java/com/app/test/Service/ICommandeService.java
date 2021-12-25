package com.app.test.Service;

import com.app.test.Model.Commande;

import java.time.LocalDate;
import java.util.List;

public interface ICommandeService {

    public Commande addCommande(Commande commande);
    public Commande updateCommande(Commande commande);
    public void deleteCommande(String num);

    public Commande findCommandeByNumero(String num);
    public List<Commande> findAllCommandes();
    public List<Commande> findCommandeByDate(LocalDate date);

}
