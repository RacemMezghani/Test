package com.app.test.Repository;

import com.app.test.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,String> {
    List<Client> findByVille(String ville);
}
