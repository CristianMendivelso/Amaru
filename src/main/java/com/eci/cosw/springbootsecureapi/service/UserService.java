package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Clase;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;

import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
public interface UserService
{
    List<User> getUsers() ;

    User getUser( int id );

    User editImage( String username, String newImage );

    User editDescription( String username, String newDescription );

    User editEmail(String username, String newEmail );

    User editPhone( String username, String newPhone );

    User findUserByUsername( String username );

    User createUser( User user );

    User findUserByEmail( String email );

    User findUserByEmailAndPassword( String email, String password );

    User editRate( String username, Double rate );

    User addGroup(String username, Clase c);

    User buy(String username,int nuevocupo);
}