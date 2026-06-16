package com.WorkBoardProject.workboard.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI WorkBoardProjectOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("WorkBoard - Task Management REST API")
                        .version("1.7")
                        .description("WorkBoard is a Task Management REST API built using Spring Boot. It allows users to manage projects, tasks, and comments with JWT-based authentication and role-based authorization.")
                        .contact(new Contact()
                                .name("Abhirama")
                                .email("abhiram.b@icloud.com")
                                .url("https://github.com/abhiramaab")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github Repository")
                        .url("https://github.com/abhiramaab/workboard"));

    }
}
