package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Clase;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service

public class UserServiceDB implements UserService {

    @Autowired
    private UserRepository usrrepo;


    @Override
    public List<User> getUsers() {
        List<User> p = usrrepo.findAll();
        return p;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    @Transactional
    public User editImage(String username, String newImage) {
        usrrepo.editImage(username, newImage);
        return findUserByUsername(username);
    }

    @Override
    @Transactional
    public User editDescription(String username, String newDescription) {
        usrrepo.editDescription(username, newDescription);
        return findUserByUsername(username);
    }

    @Override
    @Transactional
    public User editEmail(String username, String newEmail) {

        usrrepo.editEmail(username, newEmail);
        return findUserByUsername(username);
    }

    @Override
    @Transactional
    public User editPhone(String username, String newPhone) {
        usrrepo.editPhone(username, newPhone);
        return findUserByUsername(username);
    }

    @Override
    public User findUserByUsername(String username) {
        Optional optional = usrrepo.findById(username);
        User u = null;
        if (optional.isPresent()) {
            u = (User) optional.get();
        }
        return u;
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
    @Transactional
    public User editRate(String username, Double rate) {
        Optional optional = usrrepo.findById(username);
        User u = null;
        if (optional.isPresent()) {
            u = (User) optional.get();
            System.out.println(u.getNombre());
            Double oldRate = u.getRate();
            int cont = u.getTotalVotes();
            if (cont < 1) {
                usrrepo.editRate(username, redondearDecimales((oldRate + rate) / 1, 2));
            } else {
                usrrepo.editRate(username, redondearDecimales((oldRate + rate) / 2, 2));
            }
            usrrepo.editTotalVotes(username, cont + 1);

        }
        return u;
    }


    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    @Override
    public User addGroup(String username, Clase c) {
        return null;
    }

    @Override
    @Transactional
    public User buy(String username, int nuevocupo) {
        User u = findUserByUsername(username);
        usrrepo.buy(username, nuevocupo + u.getCupo());
        u.setCupo(u.getCupo() + nuevocupo);
        return u;
    }
}