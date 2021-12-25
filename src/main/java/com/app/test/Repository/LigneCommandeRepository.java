package com.app.test.Repository;

import com.app.test.Model.Commande;
import com.app.test.Model.LigneCommande;
import com.app.test.Model.Produit;
import com.app.test.Model.Produit_Commande_Ids;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Produit_Commande_Ids> {
    List<LigneCommande> findByCommande(Commande commande);

    List<LigneCommande> findByProduit(Produit produit);
}
