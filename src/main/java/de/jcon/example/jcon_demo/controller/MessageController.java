package de.jcon.example.jcon_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.jcon.example.jcon_demo.entities.Message;
import de.jcon.example.jcon_demo.repositories.MessageRepository;
import de.jcon.example.jcon_demo.services.MessageService;

@RestController()
public class MessageController {

    @Autowired
    private MessageService messages;

    @GetMapping(path = "messages")
    public Iterable<Message> getAllMessages(){
        return messages.getMessages();
    }

    @PostMapping(path = "message")
    public void addMessage(@RequestBody String message){
        messages.addNewMessage(message);
    }
}
