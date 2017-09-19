package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import com.eci.cosw.springbootsecureapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping( value = "/rate", method = RequestMethod.POST )
    public Group editRate(@RequestBody Group group){ return groupService.editRate(group.getName(),group.getRate());
    }

    @RequestMapping( path = "/register/{names}", method = RequestMethod.GET )
    public Group registerUserInGroup(@PathVariable String names) {return groupService.registerStudent(names);
    }

<<<<<<< HEAD
    @RequestMapping( path = "/groups/{name}", method = RequestMethod.GET )
    public List<Group> getGroupsByCategory(@PathVariable String name){return groupService.getGroupByGategory(name);}

=======
    @RequestMapping( value = "/comment", method = RequestMethod.POST )
    public Group addComment(@RequestBody Comment coment){
        return groupService.addCommnet(coment);
    }
>>>>>>> b3af19737617e993a93b110c8929efe42f8199ae
}


