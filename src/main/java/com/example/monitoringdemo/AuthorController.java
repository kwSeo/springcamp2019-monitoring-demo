package com.example.monitoringdemo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorClient client;

    @GetMapping("/authors")
    public List<String> getAuthors() {
        return client.getAuthorNames();
    }
}
