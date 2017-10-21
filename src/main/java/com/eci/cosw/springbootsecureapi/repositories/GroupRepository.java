package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT g FROM Group g WHERE g.category=?1")
    List<Group> categorys(String category);

    @Query("SELECT g FROM Group g WHERE g.nombre=?1")
    List<Group> names(String name);

    @Modifying
    @Query("update Group g set g.rate = ?2 where g.id = ?1")
    void editRate(long groupId, Double rate);

    @Modifying
    @Query("update Group g set g.totalVotes = ?2 where g.id = ?1")
    void editTotalVotes(long groupId, int i);


}
