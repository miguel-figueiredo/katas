package com.example.mdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String get(@RequestHeader("X-Correlation-ID") String correlationId) {
        try {
            MDC.put("correlation-id", correlationId);
            log.info("Logging hello request");
            return "Hello, world!";
        } finally {
            MDC.clear();
        }
    }
}
