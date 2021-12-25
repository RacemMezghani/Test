package com.app.test.Controller;

import com.app.test.Model.Categorie;
import com.app.test.Service.ICategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {

    @Autowired
    private ICategorieService categorieService;

    @PostMapping("/add")
    public Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie);
    }

    @PutMapping("/update")
    public Categorie updateCategorie(@RequestBody Categorie categorie){
        return categorieService.updateCategorie(categorie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategorie(@PathVariable String id){
        categorieService.deleteCategorie(id);
    }

    @GetMapping("/all")
    public List<Categorie> getAllCategories(){
        return categorieService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable String id){
        return categorieService.findCategorieByCode(id);
    }

}
