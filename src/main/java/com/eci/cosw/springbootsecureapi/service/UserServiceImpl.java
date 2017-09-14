package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {

    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "Pepito", "Perez", "https://image.freepik.com/iconos-gratis/usuario-masculino-foto-de-perfil_318-37825.jpg", "2343423","password","test@mail.com","Profesional Amigable","Instructor","pepito" ,3,1) );
    }


    public User editImage( String username, String newImage ){
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                u.setImage(newImage);
                users.set(i,u);
                break;
            }

        }
        return users.get(indice);
    };

    public User editDescription( String username, String newDescription ){
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                u.setDescription(newDescription);
                users.set(i,u);
                break;
            }
        }
        return users.get(indice);
    };

    public User editEmail(String username, String newEmail ){
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                u.setEmail(newEmail);
                users.set(i,u);
                break;
            }
        }
        return users.get(indice);
    };

    public User editPhone( String username, String newPhone ){
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                u.setPhone(newPhone);
                users.set(i,u);
                break;
            }
        }
        return users.get(indice);
    };

    @Override
    public List<User> getUsers()
    { return users;
    }

    @Override
    public User getUser( int id )
    {
        return users.get( id );
    }

    @Override
    public User createUser( User user )
    {
        synchronized (users){
            user.setId(users.size());
            users.add( user );
        }

        return user;
    }

    @Override
    public User findUserByEmail( String email )
    {
        int indice=-1;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                indice=i;
                break;
            }
        }
        if (indice==-1){
            return null;
        }
        return users.get(indice);
    }

    @Override
    public User findUserByUsername( String username )
    {
        int indice=-1;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                break;
            }
        }
        if (indice==-1){
            return null;
        }
        return users.get(indice);
    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        return users.get( 0 );
    }

    public User editRate(String username, float rate) {
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                float oldRate = u.getRate();
                int cont = u.getTotalVotes();

                u.setRate((oldRate+rate)/2);
                u.setTotalVotes(cont+1);
                users.set(i,u);
                break;
            }
        }
        return users.get(indice);
    }

}
