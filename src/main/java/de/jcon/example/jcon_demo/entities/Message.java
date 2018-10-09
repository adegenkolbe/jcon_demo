package de.jcon.example.jcon_demo.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    public Message(){};

    public Message(final String message){
        this.message = message;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Message message1 = (Message) o;
        return Objects.equals(id, message1.id) &&
                Objects.equals(message, message1.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }

    /**
     * Gets id
     *
     * @return value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets message
     *
     * @return value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message
     */
    public void setMessage(final String message) {
        this.message = message;
    }
}
