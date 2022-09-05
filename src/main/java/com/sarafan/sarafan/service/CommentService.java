package com.sarafan.sarafan.service;

import com.sarafan.sarafan.domain.Message;
import com.sarafan.sarafan.domain.Views;
import com.sarafan.sarafan.dto.EventType;
import com.sarafan.sarafan.dto.ObjectType;
import com.sarafan.sarafan.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarafan.sarafan.domain.Comment;
import com.sarafan.sarafan.domain.User;
import com.sarafan.sarafan.repo.CommentRepo;

import java.util.function.BiConsumer;

@Service
public class CommentService {
	
	private final CommentRepo commentRepo;
	private final BiConsumer<EventType, Comment> wsSender;
	
	@Autowired
	public CommentService(CommentRepo commentRepo, WsSender wsSender) {
		this.commentRepo = commentRepo;
		this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
	}

	public Comment create(Comment comment, User user) {
		comment.setAuthor(user);
		Comment commentFromDB = commentRepo.save(comment);

		wsSender.accept(EventType.CREATE, commentFromDB);
		
		return commentFromDB;
	}
}
