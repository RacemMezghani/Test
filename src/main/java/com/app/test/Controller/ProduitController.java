package com.app.test.Controller;


import com.app.test.Model.Produit;
import com.app.test.Service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitController {

    @Autowired
    private IProduitService produitService;

    @PostMapping("/add")
    public Produit addProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }

    @PutMapping("/update")
    public Produit updateProduit(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduit(@PathVariable String id){
        produitService.deleteProduit(id);
    }

    @GetMapping("/all")
    public List<Produit> getAllProduits(){
        return produitService.findAllProduits();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable String id){
        return produitService.findProduitByCode(id);
    }


}
