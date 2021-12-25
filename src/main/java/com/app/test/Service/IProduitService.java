package com.app.test.Service;

import com.app.test.Model.Categorie;
import com.app.test.Model.Produit;

import java.util.List;

public interface IProduitService {

    public Produit addProduit(Produit produit);
    public Produit updateProduit(Produit produit);
    public void deleteProduit(String code);

    public Produit findProduitByCode(String code);
    public List<Produit> findAllProduits();

    public List<Produit> findProduitByCategorie(Categorie categorie);

}
