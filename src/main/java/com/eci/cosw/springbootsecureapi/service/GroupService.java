package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Group;

/**
 * Created by 2107262 on 9/6/17.
 */
public interface GroupService {

    public Group findGroupByName(String name);
}
