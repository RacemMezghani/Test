package com.app.test.Service;

import com.app.test.Model.Categorie;

import java.util.List;

public interface ICategorieService {

    public Categorie addCategorie(Categorie categorie);
    public Categorie updateCategorie(Categorie categorie);
    public void deleteCategorie(String code);

    public Categorie findCategorieByCode(String code);
    public Categorie findCategorieByLibelle(String libelle);
    public List<Categorie> findAllCategories();


}
