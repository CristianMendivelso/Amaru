package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.Todo;
import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.ServicesException;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @RequestMapping( value = "/users", method = RequestMethod.GET )
    public List<User> getUsers(){

        return userService.getUsers();

    }

    @RequestMapping( path = "/{username}", method = RequestMethod.GET )
    public User findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);
    }

    @RequestMapping( value = "/users", method = RequestMethod.POST )
    public User setUser(@RequestBody User user){

            return userService.createUser(user);
    }

    @RequestMapping( value = "/buy", method = RequestMethod.POST )
    public User buy(@RequestBody User user){
        return userService.buy(user.getUsername(),user.getCupo());
    }

    @RequestMapping( value = "/editImage", method = RequestMethod.POST )
    public User editImage(@RequestBody User edit){

        return userService.editImage(edit.getUsername(),edit.getImage());
    }



    @RequestMapping( value = "/editPhone", method = RequestMethod.POST )
    public User editPhone(@RequestBody User edit){

        return userService.editPhone(edit.getUsername(),edit.getPhone());
    }

    @RequestMapping( value = "/editDescription", method = RequestMethod.POST )
    public User editDescription(@RequestBody User edit){

        return userService.editDescription(edit.getUsername(),edit.getDescription());
    }

    @RequestMapping( value = "/findUser", method = RequestMethod.GET )
    public User findUserByEmail(@RequestBody User user){
        return userService.findUserByEmail(user.getEmail());
    }

    @RequestMapping( value = "/editEmail", method = RequestMethod.POST )
    public User editEmail(@RequestBody User edit){
        return userService.editEmail(edit.getUsername(),edit.getEmail());
    }

    @RequestMapping( value = "/rate", method = RequestMethod.POST )
    public User editRate(@RequestBody User edit){ return userService.editRate(edit.getUsername(),edit.getRate()); }


    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {
        String jwtToken = "";

        if ( login.getUsername() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in username and password" );
        }

        String username = login.getUsername();
        String password = login.getPassword();
        User user = userService.findUserByUsername(login.getUsername());
        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }

        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
