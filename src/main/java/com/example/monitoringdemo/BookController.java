package com.example.monitoringdemo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
public class BookController {
    private final BookRepository repo;
    private final Counter counter;

    public BookController(BookRepository repo, MeterRegistry registry) {
        this.repo = repo;
        this.counter = registry.counter("book.counter", "job", "post");
//        this.counter = Counter.builder("my.book").tag("job", "post").description("my book description").register(registry);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return repo.findAll();
    }

    @GetMapping("/books/{id}")
    @Cacheable("book")
    public Book getBook(@PathVariable String id) {
        log.info("called getBook({})", id);
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/books")
    @CacheEvict(value = "book", allEntries = true)
    public Book postBook(@RequestBody Book book) {
        counter.increment();
        return repo.save(book);
    }

    @DeleteMapping("/books/{id}")
    @CacheEvict(value = "book", allEntries = true)
    public Book deleteBook(@PathVariable String id) {
        Book deletedBook = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.deleteById(id);
        return deletedBook;
    }
}
