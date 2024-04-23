package com.fon.college;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "College API", version = "1.0",
                description = "Spring Boot application designed to manage basic information about a college.",
                contact = @Contact(name = "Sergej Kubat", email = "sergej.kubat18@gmail.com",
                        url = "https://github.com/SergejKubat/")),
        servers = @Server(url = "http://localhost:8080", description = "Development server"))
public class CollegeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollegeApplication.class, args);
    }
}
