package de.jcon.example.jcon_demo.endpoints;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class RuntimeEndpoint implements Endpoint<String>{
    private static LocalDateTime start = LocalDateTime.now();

    @Override
    public String getId() {
        return "runtime";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public String invoke() {
        return String.format("Server is running for %s seconds",Duration.between(start, LocalDateTime.now()).getSeconds());
    }
}
