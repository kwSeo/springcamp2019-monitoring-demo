package com.example.monitoringdemo;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@AllArgsConstructor
@Configuration
public class SchedulerConfig {
    private final BookRepository bookRepository;

    @Scheduled(fixedDelay = 5000)
    @Timed("scheduled-job")
    public void bookJob() {
        log.info("books.size={}", bookRepository.count());
    }

}
