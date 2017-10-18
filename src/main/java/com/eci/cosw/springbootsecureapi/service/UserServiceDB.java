package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Clase;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceDB implements UserService {

    @Autowired
    private UserRepository usrrepo;


    @Override
    public List<User> getUsers() {
        List<User> p=usrrepo.findAll();
        return p;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public User editImage(String username, String newImage) {
        return null;
    }

    @Override
    public User editDescription(String username, String newDescription) {
        return null;
    }

    @Override
    public User editEmail(String username, String newEmail) {
        return null;
    }

    @Override
    public User editPhone(String username, String newPhone) {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return null;
    }

    @Override
    public User createUser(User user) {
        usrrepo.save(user);
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public User editRate(String username, Double rate) {
        return null;
    }

    @Override
    public User addGroup(String username, Clase c) {
        return null;
    }

    @Override
    public User buy(com.eci.cosw.springbootsecureapi.model.User user) {
        return null;
    }
}
