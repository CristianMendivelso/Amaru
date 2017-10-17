package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Clase;
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
        Comment co = new Comment("Excelente Grupo",1, "Pepito", "31 Marzo 2017");
        Comment co2 = new Comment("Segundo Comentario",1, "Pepito", "3 Mayo 2017");
        List<Comment> comments = new ArrayList<>();
        comments.add(co);
        comments.add(co2);
        List<Group> groups = new ArrayList<>();
        List<Clase> clases=new ArrayList<>();
        Clase c1=new Clase(1,"3 Octubre 2017","11:00","Parque el Virrey",1,"Volleyball",0);
        Clase c2=new Clase(1,"2 Octubre 2017","11:00","Parque el Virrey",2,"Volleyball",0);
        clases.add(c1);
        clases.add(c2);
        comments.add(co);
        comments.add(co2);
        groups.add( new Group( 1,"Volleyball","pepito",comments,"Aprende Volleyball Con la mejor metodología","Sports", 0.0,0,"https://www.standardmedia.co.ke/images/saturday/bcxaonet5vqlo5961439761817.jpg",clases) );
        users.add(new User("Pepito", "Perez", "https://guiafitness.com/wp-content/uploads/dieta-deportistas-principiantes.jpg", "324324324", "password", "pepito@mail.com", "Apasionado por el deporte", "AMARU", "pepito", 0.0, 0, clases ,1));
        users.add(new User("Andrea", "Romero", "http://www.mujerhoy.com/pic.aspx?w=640&h=530&img=mujercorre858913345.jpg", "324324323", "password", "andrea@mail.com", "Instructora de Voleyball", "INSTRUCTOR", "andrea", 0.0, 0, clases ,1));
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

    public User addGroup(String username, Clase c){
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(username)){
                indice=i;
                User u = users.get(i);
                List<Clase> clases= u.getClases();

                clases.add(c);
                u.setClases(clases);
                users.set(i,u);
                break;
            }
        }
        return users.get(indice);

    }

    @Override
    public User buy(User user) {
        int indice=0;
        for (int i=0;i< users.size();i++){
            if(users.get(i).getUsername().equals(user.getUsername())){
                indice=i;
                User u = users.get(i);
                int cupo = u.getCupo();
                cupo+=user.getCupo();
                u.setCupo(cupo);
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
    @Override
    public User createUser( User user )
    {
        synchronized (users){
            users.add( user );
        }

        return user;
    }

}
