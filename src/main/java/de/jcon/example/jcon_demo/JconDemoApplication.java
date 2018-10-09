package de.jcon.example.jcon_demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.jcon.example.jcon_demo.entities.Message;
import de.jcon.example.jcon_demo.repositories.MessageRepository;

@SpringBootApplication
public class JconDemoApplication {

	@Autowired
	private MessageRepository messageRepository;

	public static void main(String[] args) {
		SpringApplication.run(JconDemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			messageRepository.save(new Message("This a sample test message"));
			messageRepository.save(new Message("This is second sample message"));
		};
	}
}
