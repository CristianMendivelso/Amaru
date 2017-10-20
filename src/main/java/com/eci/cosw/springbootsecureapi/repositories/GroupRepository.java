package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Modifying
    @Query("update Group g set g.rate = ?2 where g.id = ?1")
    void editRate(long groupId, Double rate);

    @Modifying
    @Query("update Group g set g.totalVotes = ?2 where g.id = ?1")
    void editTotalVotes(long groupId, int i);
}
