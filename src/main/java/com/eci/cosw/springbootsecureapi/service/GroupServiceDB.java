package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        List<Group> names = this.getAllGroups();
        System.out.println(names.size());
        for(int i=0;i<names.size();i++){
            if(name.equals(names.get(i).getName())){
                names.add(names.get(i));
            }
        }
        return names;

    }

    @Override
    public Group getGroupByid(long groupId) {
        return null;
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
        return null;
    }

    @Override
    public Group addCommnet(Comment comment) {
        return null;
    }
}
