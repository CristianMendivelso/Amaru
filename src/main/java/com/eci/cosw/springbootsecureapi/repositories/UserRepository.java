package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {


    @Modifying
    @Query("update User u set u.rate = ?2 where u.username = ?1")
    void editRate(String username, Double rate);

    @Modifying
    @Query("update User u set u.totalVotes = ?2 where u.username = ?1")
    void editTotalVotes(String username, int i);
}