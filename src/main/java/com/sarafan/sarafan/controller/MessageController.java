package com.sarafan.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sarafan.sarafan.domain.Message;
import com.sarafan.sarafan.domain.Views;
import com.sarafan.sarafan.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author @bkalika
 * Created on 12.06.2022 10:29 AM
 */
@RestController
@RequestMapping("message")
public class MessageController {
//    private int counter = 4;
//    private final List<Map<String, String>> messages = new ArrayList<>() {{
//        add(new HashMap<>() {{put("id", "1"); put("text", "First message");}});
//        add(new HashMap<>() {{put("id", "2"); put("text", "Second message");}});
//        add(new HashMap<>() {{put("id", "3"); put("text", "Third message");}});
//    }};

    private final MessageRepo messagesRepo;

    @Autowired
    public MessageController(MessageRepo messagesRepo) {
        this.messagesRepo = messagesRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messagesRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreatedDate(LocalDateTime.now());
        return messagesRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");

        return messagesRepo.save(messageFromDb);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messagesRepo.delete(message);
    }

}
