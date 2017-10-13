package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Clase;
import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2107262 on 9/6/17.
 */
@Service
public class GroupServiceImpl implements GroupService{

    private List<Group> groups = new ArrayList<>();


    @Autowired
    public UserService users;

    @PostConstruct
    private void populateSampleData()
    {
        Comment co = new Comment("Excelente Grupo",1, "Pepito", "31 Marzo 2017");
        Comment co2 = new Comment("Segundo Comentario",1, "Pepito", "3 Mayo 2017");
        List<Comment> comments = new ArrayList<>();
        Clase c1=new Clase(1,"3 Octubre 2017","11:00","Parque el Virrey",1,"Volleyball");
        Clase c2=new Clase(1,"2 Octubre 2017","11:00","Parque el Virrey",2,"Volleyball");
        List< Clase > clases=new ArrayList<>();
        clases.add(c1);
        clases.add(c2);
        comments.add(co);
        comments.add(co2);
        groups.add( new Group( 1,"Volleyball","pepito",comments,"Aprende Volleyball Con la mejor metodología","Sports", 4.0,2,"https://www.standardmedia.co.ke/images/saturday/bcxaonet5vqlo5961439761817.jpg",clases) );

    }

    @Override
    public Group editPlace(long groupId, String newPlace) {
        return null;
    }

    @Override
    public Group editHour(long groupId, String newHour) {
        return null;
    }


    @Override
    public Group editDescription(long groupId, String newDescription) {
        return null;
    }

    @Override
    public Group editName(long groupId, String newName) {
        return null;
    }

    @Override
    public List<Group> getGroupByName(String name) {
        List<Group> categories=new ArrayList<>();
        for(int i=0;i<groups.size();i++){
            if(name.equals(groups.get(i).getName())){
                categories.add(groups.get(i));
            }
        }
        return categories;

    }

    @Override
    public Group registerStudent(long groupId, String username){
        /*String[] n = names.split(",");
        Group g = null;
        for (Group group : groups){
            if (group.getName().equals(n[0])){
                ArrayList<User> students = group.getStudents();
                students.add(this.users.findUserByUsername(n[1]));
                group.setStudents(students);
                g = group;
                users.addGroup(n[1],group);
                break;
            }
        }

        return g;*/
        return null;
    }

    @Override
    public List<Group> getGroupByGategory(String name) {
        List<Group> categories=new ArrayList<>();
        for(int i=0;i<groups.size();i++){
            if(name.equals(groups.get(i).getCategory())){
                categories.add(groups.get(i));
            }
        }
        return categories;
    }

    @Override
    public Group  getGroupByid(long groupId ){
        Group group = null;
        for (Group g : groups){
            if (g.getId()==groupId){
                group = g;
                break;
            }
        }
        return group;
    }

    @Override
    public Group createGroup(Group group) {
        group.setId(groups.size());
        groups.add(group);
        for(Clase c:group.getClases()){
            users.addGroup(group.getInstructor(),c);
        }
        return groups.get(groups.size() - 1);
    }

    public Group editRate(long groupId, Double rate) {
        int indice=0;
        for (int i=0;i< groups.size();i++){
            if(groups.get(i).getId()==groupId){
                indice=i;
                Group g = groups.get(i);
                Double oldRate = g.getRate();
                int cont = g.getTotalVotes();
                g.setRate( redondearDecimales((oldRate+rate)/2,2) );
                g.setTotalVotes(cont+1);
                groups.set(i,g);
                break;
            }
        }
        return groups.get(indice);
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


    public Group addCommnet(Comment comment) {
        int indice=0;
        for (int i=0;i< groups.size();i++){
            if(groups.get(i).getId()==comment.getGroupId()){
                indice=i;
                Group g = groups.get(i);
                List<Comment> temp= g.getComments();
                temp.add(comment);
                g.setComments(temp);
                groups.set(i,g);
                break;
            }
        }

        return groups.get(indice);
    }

}
