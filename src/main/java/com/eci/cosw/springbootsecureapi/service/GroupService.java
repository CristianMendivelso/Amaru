package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;

import java.util.List;

/**
 * Created by 2107262 on 9/6/17.
 */
public interface GroupService {


    public Group findGroupByName(String name);
    Group editPlace(String name, String newPlace);

    Group editHour(String name, String newHour);

    Group editDays(String name, String[] newDays);

    Group editDescription(String name, String newDescription);

    Group editName(String name, String newName);

<<<<<<< HEAD
=======
    Group getGroupByName(String name);

    Group createGroup(Group group);

    Group editRate( String groupname, Double rate );

    Group registerStudent(String names);

    List<Group> getGroupByGategory(String name);

    Group addCommnet(Comment comment);


>>>>>>> origin/master

}
