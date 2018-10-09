package de.jcon.example.jcon_demo.endpoints;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "runtime")
public class RuntimeEndpoint{
    private static LocalDateTime start = LocalDateTime.now();

    @ReadOperation
    public String getAcutalRuntime() {
        return String.format("Server is running for %s seconds",Duration.between(start, LocalDateTime.now()).getSeconds());
    }
}
