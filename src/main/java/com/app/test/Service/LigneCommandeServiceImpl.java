package com.app.test.Service;

import com.app.test.Model.Commande;
import com.app.test.Model.LigneCommande;
import com.app.test.Model.Produit;
import com.app.test.Model.Produit_Commande_Ids;
import com.app.test.Repository.CommandeRepository;
import com.app.test.Repository.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeServiceImpl implements ILigneCommandeService {

    @Autowired
    private LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public LigneCommande addLigneCommande(LigneCommande ligneCommande) {

        if(ligneCommande.getCommande().getPrixTotal()==null){
            ligneCommande.getCommande().setPrixTotal(ligneCommande.getPrixTotal());
        }
        else{
            ligneCommande.getCommande().setPrixTotal(ligneCommande.getCommande().getPrixTotal().add(ligneCommande.getPrixTotal()));
        }
        commandeRepository.save(ligneCommande.getCommande());
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public LigneCommande updateLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public void deleteLigneCommande(Produit_Commande_Ids id) {
        LigneCommande ligneCommande= findLigneCommandeById(id);
        ligneCommandeRepository.delete(ligneCommande);
    }

    @Override
    public LigneCommande findLigneCommandeById(Produit_Commande_Ids id) {
        return ligneCommandeRepository.getById(id);
    }

    @Override
    public List<LigneCommande> findAllLigneCommandes() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public List<LigneCommande> findLigneCommandeByCommande(Commande commande) {
        return ligneCommandeRepository.findByCommande(commande);
    }

    @Override
    public List<LigneCommande> findLigneCommandeByProduit(Produit produit) {
        return ligneCommandeRepository.findByProduit(produit);
    }
}
