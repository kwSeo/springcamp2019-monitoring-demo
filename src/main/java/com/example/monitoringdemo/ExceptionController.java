package com.example.monitoringdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @GetMapping("/exception")
    public void exception() {
        throw new SomeException("Failed");
    }

    static class SomeException extends RuntimeException {
        SomeException(String msg) {
            super(msg);
        }
    }
}
