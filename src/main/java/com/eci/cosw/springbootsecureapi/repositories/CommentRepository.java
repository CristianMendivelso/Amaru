package com.eci.cosw.springbootsecureapi.repositories;

import com.eci.cosw.springbootsecureapi.model.Comment;
import com.eci.cosw.springbootsecureapi.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Long> {

}
