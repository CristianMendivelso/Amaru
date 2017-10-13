package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Clase;
import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;

import java.util.List;

/**
 * Created by 2107262 on 9/6/17.
 */
public interface GroupService {

    Group editPlace(long groupId, String newPlace);

    Group editHour(long groupId, String newHour);

    Group editDescription(long groupId, String newDescription);

    Group editName(long groupId, String newName);

    List<Group> getGroupByName(String name);

    Group getGroupByid(long groupId );

    Group createGroup(Group grupo);

    Group editRate( long groupId, Double rate );

    Group registerStudent(long groupId,String username);

    List<Group> getGroupByGategory(String name);

    Group addCommnet(Comment comment);



}
