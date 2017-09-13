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

    @RequestMapping( value = "/{name}", method = RequestMethod.GET )
    public Group getGroup(@PathVariable String name){
        return groupService.findGroupByName(name);
    }


}
