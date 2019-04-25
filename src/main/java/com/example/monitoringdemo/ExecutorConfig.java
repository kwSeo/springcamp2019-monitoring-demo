package com.example.monitoringdemo;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ExecutorConfig {
    @Bean
    public ExecutorService someExecutor(MeterRegistry registry) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        Gauge.builder("book.executor.max", () -> executor.getMaximumPoolSize()).tag("name", "someExecutor").register(registry);
        Gauge.builder("book.executor.active", () -> executor.getActiveCount()).tag("name", "someExecutor").register(registry);
        Gauge.builder("book.executor.complete", () -> executor.getCompletedTaskCount()).tag("name", "someExecutor").register(registry);

        return executor;
    }
}
