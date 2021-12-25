package com.app.test.Service;

import com.app.test.Model.Categorie;
import com.app.test.Model.Produit;
import com.app.test.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements IProduitService{

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(String code) {
        Produit produit= findProduitByCode(code);
        produitRepository.delete(produit);

    }

    @Override
    public Produit findProduitByCode(String code) {
        return produitRepository.findById(code).get();
    }

    @Override
    public List<Produit> findAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> findProduitByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }
}
