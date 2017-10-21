package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.persistence.EntityManager;


import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {


    @Modifying
    @Query("update User u set u.rate = ?2 where u.username = ?1")
    void editRate(String username, Double rate);

    @Modifying
    @Query("update User u set u.totalVotes = ?2 where u.username = ?1")
    void editTotalVotes(String username, int i);

    @Query("update User u set u.image = ?2 where u.username = ?1")
    void editImage(String username, String newImage);

    @Modifying
     @Query("update User u set u.description = ?2 where u.username = ?1")
     void editDescription(String username, String newDescription);

      @Modifying
     @Query("update User u set u.email = ?2 where u.username = ?1")
     void editEmail(String username, String newEmail);

      @Modifying
     @Query("update User u set u.phone = ?2 where u.username = ?1")
     void editPhone(String username, String newPhone);

      @Modifying
     @Query("update User u set u.cupo = ?2 where u.username = ?1")
     void buy(String username,int nuevocupo);
}