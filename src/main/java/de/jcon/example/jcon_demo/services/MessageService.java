package de.jcon.example.jcon_demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jcon.example.jcon_demo.entities.Message;
import de.jcon.example.jcon_demo.repositories.MessageRepository;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Iterable<Message> getMessages(){
        return messageRepository.findAll();
    }

    public void addNewMessage(final String message){
        messageRepository.save(new Message(message));
    }

}
