package com.app.test.Repository;

import com.app.test.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, String> {
    List<Commande> findByDate(LocalDate date);
}
