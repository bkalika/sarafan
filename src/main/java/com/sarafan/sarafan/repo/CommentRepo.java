package com.sarafan.sarafan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarafan.sarafan.domain.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {

}
