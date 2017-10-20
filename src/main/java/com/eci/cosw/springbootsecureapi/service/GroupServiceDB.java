package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceDB  implements GroupService {


    @Autowired
    private GroupRepository grprepo;

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
        return null;
    }

    @Override
    public Group editRate(long groupId, Double rate) {
        return null;
    }

    @Override
    public List<Group> getGroupByGategory(String name) {
        return grprepo.categorys(name);
    }

    @Override
    public Group addCommnet(Comment comment) {
        return null;
    }
}
