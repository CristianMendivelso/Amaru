package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 2107262 on 9/6/17.
 */
@RestController
@RequestMapping( "group" )
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping( path = "/{groupname}", method = RequestMethod.GET )
    public Group getGroupByName(@PathVariable String groupname){
        return groupService.getGroupByName(groupname);
    }

    @RequestMapping( value = "/groups", method = RequestMethod.POST )
    public Group setUser(@RequestBody Group group){
        return groupService.createGroup(group);
    }
}
