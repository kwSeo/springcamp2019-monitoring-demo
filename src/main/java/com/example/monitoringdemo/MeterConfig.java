package com.example.monitoringdemo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MeterConfig implements MeterRegistryCustomizer<MeterRegistry> {
    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void customize(MeterRegistry registry) {
        registry.config()
                .commonTags("applicationName", applicationName)
                .meterFilter(MeterFilter.denyNameStartsWith("system"));
    }
}
