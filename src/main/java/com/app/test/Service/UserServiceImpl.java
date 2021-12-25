package com.app.test.Service;

import com.app.test.Model.Client;
import com.app.test.Model.User;
import com.app.test.Repository.ClientRepository;
import com.app.test.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String code) {
        User user = findUserByCode(code);
        userRepository.delete(user);

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserByCode(String code) {
        return userRepository.findById(code).get();
    }

    @Override
    public List<User> findUserByNom(String nom) {
        return userRepository.findByNom(nom);
    }

    @Override
    public List<User> findUserByPrenom(String prenom) {
        return userRepository.findByPrenom(prenom);
    }

    @Override
    public List<User> findUserByNomAndPrenom(String nom, String prenom) {
        return userRepository.findByNomAndPrenom(nom,prenom);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> findClientByVille(String ville) {
        return clientRepository.findByVille(ville);
    }
}
