package com.app.test.Controller;

import com.app.test.Model.Commande;
import com.app.test.Service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private ICommandeService commandeService;

    @PostMapping("/add")
    public Commande addCommande(@RequestBody Commande commande){
        return commandeService.addCommande(commande);
    }

    @PutMapping("/update")
    public Commande updateCommande(@RequestBody Commande commande){
        return commandeService.updateCommande(commande);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCommande(@PathVariable String id){
        commandeService.deleteCommande(id);
    }

    @GetMapping("/all")
    public List<Commande> getAllCommandes(){
        return commandeService.findAllCommandes();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable String id){
        return commandeService.findCommandeByNumero(id);
    }
}
