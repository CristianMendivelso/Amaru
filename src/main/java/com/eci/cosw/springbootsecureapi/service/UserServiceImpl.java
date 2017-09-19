package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.text.NumberFormat;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@Service
public class UserServiceImpl implements UserService
{

    private List<User> users = new ArrayList<>();
    @Autowired
    GroupService grupos;


    @Autowired
    public UserServiceImpl()
    {

    }

    @PostConstruct
    private void populateSampleData()
    {
        String[] days = {"Friday", "Sunday"};
        Comment co = new Comment("primer comentario :v","Pepito","Volleyball");
        Comment co2 = new Comment("Segundo comentario >:v","Pepito","Volleyball");
        List<Comment> comments = new ArrayList<>();
        comments.add(co);
        comments.add(co2);
        List<Group> groups = new ArrayList<>();

        Group g= new Group( "Volleyball", null, "Parque el virrey", days, "10:00 am - 12:00 pm", "Learn how to play volleyball, and enjoy your morning exercising","Sports",comments, 0.0,0,  "http://www.longbeachny.gov/vertical/Sites/%7BC3C1054A-3D3A-41B3-8896-814D00B86D2A%7D/uploads/bigstock-Beach-Volleyball-Silhouette-81799844_(1).jpg");
        groups.add(g);
        users.add( new User( "Pepito", "Perez", "https://image.freepik.com/iconos-gratis/usuario-masculino-foto-de-perfil_318-37825.jpg", "2343423","password","test@mail.com","Profesional Amigable","INSTRUCTOR","pepito" ,3.0,1,groups) );
        users.add( new User( "Laura", "Soto", "https://cde.peru.com/ima/0/1/1/6/5/1165933/924x530/facebook.jpg", "2343423","password","laura@mail.com","Dispuesta a aprender","AMARU","laura" ,5.0,0,groups) );
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

    public User addGroup(String username, Group g){
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                List<Group> group= u.getGroups();
                group.add(g);
                u.setGroups(group);
                users.set(i,u);
                break;
            }
        }
        return users.get(indice);

    }

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

    public User editRate(String username, Double rate) {
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                Double oldRate = u.getRate();
                int cont = u.getTotalVotes();

                u.setRate( redondearDecimales((oldRate+rate)/2,2) );
                u.setTotalVotes(cont+1);
                users.set(i,u);
                break;
            }
        }
        return users.get(indice);
    }
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }

}
