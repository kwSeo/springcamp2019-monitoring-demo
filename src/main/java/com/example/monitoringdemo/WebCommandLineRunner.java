package com.example.monitoringdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WebCommandLineRunner implements CommandLineRunner {
    private final BookRepository repo;

    public WebCommandLineRunner(BookRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("initializing sample data");
        repo.save(new Book("b1", "Java Programming", "Foo", 30000));
        repo.save(new Book("b2", "C++ Programming", "Bar", 25000));
        repo.save(new Book("b3", "The Load of the Rings", "J. R. R. Tolkien", 50000));
        repo.save(new Book("b4", "Starcraft", "Bri", 20000));
        repo.save(new Book("b5", "IRONMAN", "He", 15000));
    }
}
