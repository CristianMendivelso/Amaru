package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.repositories.CommentRepository;
import com.eci.cosw.springbootsecureapi.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceDB  implements GroupService {


    @Autowired
    private GroupRepository grprepo;

    @Autowired
    private CommentRepository cmrepo;

    public List<Group> getAllGroups() {
        List<Group> groups = grprepo.findAll();
        return groups;
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
        return grprepo.names(name);


    }

    @Override
    public Group getGroupByid(long groupId) {
        Optional optional= grprepo.findById(groupId);
        Group g=null;
        if ( optional.isPresent() ){
            g=(Group) optional.get();
        }
        return g;

    }

    @Override
    public boolean subscribe(long idclase, long idgroup, String username) {
        return false;
    }

    @Override
    public Group createGroup(Group grupo) {
        List<Group> names = this.getAllGroups();
        grupo.setId(names.size());
        grprepo.save(grupo);
        return grupo;
    }

    @Override
    @Transactional
    public Group editRate(long groupId, Double rate) {
        Optional optional= grprepo.findById(groupId);
        Group g=null;
        if ( optional.isPresent() ){
            g=(Group)optional.get();
            System.out.println(g.getNombre());
            Double oldRate = g.getRate();
            int cont = g.getTotalVotes();
            if (cont<1){
                grprepo.editRate(groupId,redondearDecimales((oldRate+rate)/1,2) );
            }
            else {
                grprepo.editRate(groupId,redondearDecimales((oldRate+rate)/2,2) );
            }
            grprepo.editTotalVotes(groupId,cont+1);

        }
        return g;
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
    public List<Group> getGroupByGategory(String name) {
        return grprepo.categorys(name);
    }

    @Override
    public Group addCommnet(Comment comment) {

        Optional optional= grprepo.findById(comment.getGroupId());
        Group g=null;
        if ( optional.isPresent() ){
            g=(Group) optional.get();
            List<Comment> comentarios = g.getComments();
            comment.setId(comentarios.size());
            comment.setFecha(new Date().toString());
            comentarios.add(comment);
            g.setComments(comentarios);
            grprepo.save(g);
        }
        return g;
    }
}
