package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

=======

import javax.annotation.PostConstruct;
>>>>>>> origin/master
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2107262 on 9/6/17.
 */

@Service
public class GroupServiceImpl implements GroupService{

<<<<<<< HEAD
    private List<Group> groups=new ArrayList<Group>();
    @Autowired
    public GroupServiceImpl(){

    }
    @Override
    public Group findGroupByName(String name) {
        Group found=null;
        for(int i=0;i<groups.size();i++){
            if(groups.get(i).getName().equals(name)) {
                found = groups.get(i);
            }
        }
        return found;
=======
    private List<Group> groups = new ArrayList<>();
    private UserServiceImpl users = new UserServiceImpl();

    @Autowired
    public GroupServiceImpl()
    {

    }

    @PostConstruct
    private void populateSampleData()
    {
        String[] days = {"Saturday", "Sunday"};
        groups.add( new Group( "Volleyball", users.getUsers().get(0), "Parque el virrey", "10:00 am - 12:00 pm", days, "Learn how to play volleyball, and enjoy your morning exercising") );
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
>>>>>>> origin/master
    }
}
