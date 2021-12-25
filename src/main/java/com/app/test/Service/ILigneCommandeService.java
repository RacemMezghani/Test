package com.app.test.Service;

import com.app.test.Model.Commande;
import com.app.test.Model.LigneCommande;
import com.app.test.Model.Produit;
import com.app.test.Model.Produit_Commande_Ids;

import java.util.List;

public interface ILigneCommandeService {

    public LigneCommande addLigneCommande(LigneCommande ligneCommande);
    public LigneCommande updateLigneCommande(LigneCommande ligneCommande);
    public void deleteLigneCommande(Produit_Commande_Ids id);

    public LigneCommande findLigneCommandeById(Produit_Commande_Ids id);
    public List<LigneCommande> findAllLigneCommandes();
    public List<LigneCommande> findLigneCommandeByCommande(Commande commande);
    public List<LigneCommande> findLigneCommandeByProduit(Produit produit);


}
