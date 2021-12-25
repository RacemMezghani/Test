package com.app.test.Repository;

import com.app.test.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);

    List<User> findByNom(String nom);

    List<User> findByPrenom(String prenom);

    List<User> findByNomAndPrenom(String nom, String prenom);
}
