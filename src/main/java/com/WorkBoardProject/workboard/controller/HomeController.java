package com.WorkBoardProject.workboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>WorkBoard REST API</title>
            <style>
                body{
                    font-family:Arial,sans-serif;
                    text-align:center;
                    margin-top:100px;
                    background:#f5f5f5;
                }
                a{
                    display:inline-block;
                    padding:12px 24px;
                    background:#28a745;
                    color:white;
                    text-decoration:none;
                    border-radius:6px;
                    font-size:18px;
                }
            </style>
        </head>
        <body>
            <h1>WorkBoard - Task Management REST API</h1>
            <p>WorkBoard is a Task Management REST API built using Spring Boot. It enables secure project, task, comment, and user management through JWT-based authentication and role-based authorization.</p>

            <a href="/swagger-ui/index.html">
                View Swagger Documentation
            </a>
        </body>
        </html>
        """;
    }
}
