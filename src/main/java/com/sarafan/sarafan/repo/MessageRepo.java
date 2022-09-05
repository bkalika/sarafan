package com.sarafan.sarafan.repo;

import com.sarafan.sarafan.domain.Message;


import com.sarafan.sarafan.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author @bkalika
 * Created on 16.06.2022 8:53 PM
 */
public interface MessageRepo extends JpaRepository<Message, Long> {
	@EntityGraph(attributePaths = {"comments"})
	Page<Message> findByAuthorIn(List<User> users, Pageable pageable);

}
