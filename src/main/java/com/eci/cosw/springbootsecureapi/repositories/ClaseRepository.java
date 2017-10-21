package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase,Integer> {

    @Modifying
    @Query("update Clase c set c.numinscritos = ?2 where c.idclase = ?1")
    void setNumInscritos(long idclase, int numinscritos);


}