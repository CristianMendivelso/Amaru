package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 2107262 on 9/6/17.
 */

@Service
public class GroupServiceImpl implements GroupService{

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
    }
}
