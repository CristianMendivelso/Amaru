package com.eci.cosw.springbootsecureapi.service;

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
        String[] days = {"Friday", "Sunday"};
        Comment co = new Comment("primer comentario :v","Pepito","Volleyball");
        Comment co2 = new Comment("Segundo comentario >:v","Pepito","Volleyball");
        List<Comment> comments = new ArrayList<>();
        comments.add(co);
        comments.add(co2);

        groups.add( new Group( "Volleyball", null, "Parque el virrey", days, "10:00 am - 12:00 pm", "Learn how to play volleyball, and enjoy your morning exercising","Sports",comments, 0.0,0,  "http://www.longbeachny.gov/vertical/Sites/%7BC3C1054A-3D3A-41B3-8896-814D00B86D2A%7D/uploads/bigstock-Beach-Volleyball-Silhouette-81799844_(1).jpg") );

    }

    @Override
    public Group editPlace(String name, String newPlace) {
        return null;
    }

    @Override
    public Group editHour(String name, String newHour) {
        return null;
    }

    @Override
    public Group editDays(String name, String[] newDays) {
        return null;
    }

    @Override
    public Group editDescription(String name, String newDescription) {
        return null;
    }

    @Override
    public Group editName(String name, String newName) {
        return null;
    }

    @Override
    public Group registerStudent(String names){
        String[] n = names.split(",");
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

        return g;
    }

    @Override
    public Group getGroupByName(String groupname) {
        Group group = null;
        for (Group g : groups){
            if (g.getName().equals(groupname)){
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
        users.addGroup(group.getInstructor().getUsername(),group);
        return groups.get(groups.size() - 1);
    }

    public Group editRate(String groupname, Double rate) {
        int indice=0;
        for (int i=0;i< groups.size();i++){
            if(groups.get(i).getName().equals(groupname)){
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
            if(groups.get(i).getName().equals(comment.getGroupName())){
                indice=i;
                Group g = groups.get(i);
                g.addComment(comment);
                groups.set(i,g);
                break;
            }
        }

        return groups.get(indice);
    }

}
