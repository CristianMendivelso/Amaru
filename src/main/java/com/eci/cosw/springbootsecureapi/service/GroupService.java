package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Group;

/**
 * Created by 2107262 on 9/6/17.
 */
public interface GroupService {

    Group editPlace(String name, String newPlace);

    Group editHour(String name, String newHour);

    Group editDays(String name, String[] newDays);

    Group editDescription(String name, String newDescription);

    Group editName(String name, String newName);

    Group getGroupByName(String name);

    Group createGroup(Group group);

    Group editRate( String groupname, Double rate );

}
