package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
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
    public GroupServiceImpl()
    {

    }

    @PostConstruct
    private void populateSampleData()
    {
        String[] days = {"Friday", "Sunday"};
        Comment co = new Comment("primer comentario :v","Pepito",true);
        Comment co2 = new Comment("Segundo comentario >:v","Pepito",false);
        Comment[] comments = {co,co2};
        groups.add( new Group( "Volleyball", null, "Parque el virrey", days, "10:00 am - 12:00 pm", "Learn how to play volleyball, and enjoy your morning exercising","Sports",comments,3.0,1) );
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

}
