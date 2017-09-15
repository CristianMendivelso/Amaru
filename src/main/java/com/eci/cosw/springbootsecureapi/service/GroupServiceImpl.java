package com.eci.cosw.springbootsecureapi.service;

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
    private UserServiceImpl users = new UserServiceImpl();

    @Autowired
    public GroupServiceImpl()
    {

    }

    @PostConstruct
    private void populateSampleData()
    {
        String[] days = {"Friday", "Sunday"};
        groups.add( new Group( "Volleyball", null, "Parque el virrey", days, "10:00 am - 12:00 pm", "Learn how to play volleyball, and enjoy your morning exercising","Sports") );
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
            }
        }
        return group;
    }

    @Override
    public Group createGroup(Group group) {
        group.setId(groups.size());
        System.out.println(group.toString());
        groups.add(group);
        return groups.get(groups.size() - 1);
    }

}
