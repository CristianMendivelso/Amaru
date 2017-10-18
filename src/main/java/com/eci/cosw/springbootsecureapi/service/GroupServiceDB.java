package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceDB  implements GroupService {


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
        return null;
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
