package com.app.test.Service;

import com.app.test.Model.Client;
import com.app.test.Model.User;

import java.util.List;

public interface IUserService {


    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(String code);
    public List<User> findAllUsers();

    public User findUserByEmail(String email);
    public User findUserByCode(String code);

    public List<User> findUserByNom(String nom);
    public List<User> findUserByPrenom(String prenom);
    public List<User> findUserByNomAndPrenom(String nom, String prenom);


    public List<Client> findAllClients();
    public List<Client> findClientByVille(String ville);




}
