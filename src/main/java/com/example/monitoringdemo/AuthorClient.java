package com.example.monitoringdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class AuthorClient {
    private AtomicInteger value = new AtomicInteger(0);

    @HystrixCommand(fallbackMethod = "authorFallback")
    public List<String> getAuthorNames() {
        try {
            Thread.sleep(100 + value.getAndAdd(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList("hello", "world");
    }

    public List<String> authorFallback() {
        log.warn("circuit breaker open");
        return Collections.emptyList();
    }
}
