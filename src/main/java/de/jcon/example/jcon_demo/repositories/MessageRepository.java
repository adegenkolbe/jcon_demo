package de.jcon.example.jcon_demo.repositories;

import org.springframework.data.repository.CrudRepository;

import de.jcon.example.jcon_demo.entities.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
