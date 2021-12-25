package com.app.test.Controller;


import com.app.test.Model.LigneCommande;
import com.app.test.Model.Produit_Commande_Ids;
import com.app.test.Service.ILigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ligneCommande")
public class LigneCommandeController {

    @Autowired
    private ILigneCommandeService ligneCommandeService;

    @PostMapping("/add")
    public LigneCommande addLigneCommande(@RequestBody LigneCommande ligneCommande){
        return ligneCommandeService.addLigneCommande(ligneCommande);
    }

    @PutMapping("/update")
    public LigneCommande updateLigneCommande(@RequestBody LigneCommande ligneCommande){
        return ligneCommandeService.updateLigneCommande(ligneCommande);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLigneCommande(@PathVariable Produit_Commande_Ids id){
        ligneCommandeService.deleteLigneCommande(id);
    }

    @GetMapping("/all")
    public List<LigneCommande> getAllLigneCommandes(){
        return ligneCommandeService.findAllLigneCommandes();
    }

    @GetMapping("/{id}")
    public LigneCommande getLigneCommandeById(@PathVariable Produit_Commande_Ids id){
        return ligneCommandeService.findLigneCommandeById(id);
    }



}
