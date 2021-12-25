package com.app.test.Service;

import com.app.test.Model.Commande;
import com.app.test.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommandeServiceImpl implements ICommandeService{

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(String num) {
        Commande commande= findCommandeByNumero(num);
        commandeRepository.delete(commande);

    }

    @Override
    public Commande findCommandeByNumero(String num) {
        return commandeRepository.getById(num);
    }

    @Override
    public List<Commande> findAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public List<Commande> findCommandeByDate(LocalDate date) {
        return commandeRepository.findByDate(date);
    }
}
