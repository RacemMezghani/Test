package com.app.test.Service;

import com.app.test.Model.Categorie;
import com.app.test.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements ICategorieService{

    @Autowired
    private CategorieRepository categorieRepository;


    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(String code) {
        Categorie categorie= findCategorieByCode(code);
        categorieRepository.delete(categorie);

    }

    @Override
    public Categorie findCategorieByCode(String code) {
        return categorieRepository.getById(code);
    }

    @Override
    public Categorie findCategorieByLibelle(String libelle) {
        return categorieRepository.findByLibelle(libelle);
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }
}
