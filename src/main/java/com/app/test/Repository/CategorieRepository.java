package com.app.test.Repository;

import com.app.test.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,String> {
    Categorie findByLibelle(String libelle);
}
