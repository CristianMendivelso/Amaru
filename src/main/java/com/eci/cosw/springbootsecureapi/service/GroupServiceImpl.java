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
public class GroupServiceImpl implements GroupService{

    private List<Group> groups = new ArrayList<>();
    private  List<Comment> commentslist=new ArrayList<>();


    @Autowired
    public UserService users;

    @PostConstruct
    private void populateSampleData()
    {
        Comment co = new Comment("Excelente Grupo",1, "Pepito", "31 Marzo 2017",0);
        Comment co2 = new Comment("Segundo Comentario",1, "Pepito", "3 Mayo 2017",1);
        List<Comment> comments = new ArrayList<>();
        commentslist.add(co);
        commentslist.add(co2);
        Clase c1=new Clase(1,"3 Octubre 2017","11:00","Parque el Virrey",1,"Volleyball",0,"leonardo");
        Clase c2=new Clase(1,"2 Octubre 2017","11:00","Parque el Virrey",2,"Volleyball",0,"leonardo");
        List< Clase > clases=new ArrayList<>();
        clases.add(c1);
        clases.add(c2);
        comments.add(co);
        comments.add(co2);
        groups.add( new Group( 1,"Volleyball","andrea",comments,"Aprende Volleyball Con la mejor metodología","Sports", 4.0,2,"https://www.standardmedia.co.ke/images/saturday/bcxaonet5vqlo5961439761817.jpg",clases) );

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

    public void EditGroup(Group g){
        int index=0;
        for (int i=0;i<groups.size();i++){
            if (groups.get(i).getId()==g.getId()){
                index=i;
                break;
            }
        }
        groups.set(index,g);

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
        System.out.println(groupId+" groupid");
        Group group = null;
        for (Group g : groups){
            System.out.println(g.getName()+" "+g.getId());
            if (g.getId()==groupId){
                group = g;
                break;
            }
        }
        return group;
    }

    @Override
    public boolean subscribe(long idclase, long idgroup, String username) {
        User u= users.findUserByUsername(username);
        if (u.getCupo()>0){
            Clase te=null;
            Group g = getGroupByid(idgroup);
            for (Clase clase: g.getClases()){
                if(clase.getId_clase()==idclase){
                    List<Clase> temp=u.getClases();
                    clase.setNum_inscritos(clase.getNum_inscritos()+1);
                    te=clase;
                    temp.add(clase);
                    u.setClases(temp);
                    u.setCupo(u.getCupo()-1);
                    break;
                }
            }
            List<Clase> temp= g.getClases();
            int index=0;
            for (int j=0;j<temp.size();j++){
                if (temp.get(j).getId_clase()==te.getId_clase()){
                    index=j;
                    break;
                }
            }
            temp.set(index,te);
            g.setClases(temp);
            EditGroup(g);
            return true;
        }
        return false;
    }

    @Override
    public Group createGroup(Group group) {
        int a=groups.size()+1;
        group.setId(a);
        groups.add(group);
        int cont=0;
        for(Clase c:group.getClases()){
            c.setGroup_id(a);
            c.setId_clase(cont);
            cont+=1;
            users.addGroup(group.getInstructor(),c);
        }
        return group;
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

    @Override
    public List<Group> getAllGroups() {
        return null;
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
        commentslist.add(comment);
        comment.setId(commentslist.size());
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
