package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.model.User;
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
    private UserService users = new UserServiceImpl();

    @Autowired
    public GroupServiceImpl()
    {

    }

    @Override
    public Group findGroupByName(String name) {
        Group found = null;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getName().equals(name)) {
                found = groups.get(i);
            }
        }
        return found;
    }





    @PostConstruct
    private void populateSampleData()
    {
        String[] days = {"Saturday", "Sunday"};
        groups.add( new Group( "Volleyball",  new User( "Pepito", "Perez", "https://image.freepik.com/iconos-gratis/usuario-masculino-foto-de-perfil_318-37825.jpg", "2343423","password","test@mail.com","Profesional Amigable","Instructor","pepito" ), "Parque el virrey", "10:00 am - 12:00 pm", days, "Learn how to play volleyball, and enjoy your morning exercising") );
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
}
