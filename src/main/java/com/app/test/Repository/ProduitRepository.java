package com.app.test.Repository;

import com.app.test.Model.Categorie;
import com.app.test.Model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, String> {
    List<Produit> findByCategorie(Categorie categorie);
}
