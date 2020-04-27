package com.example.spring.restart.testfailure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Controller {
    @GetMapping(path = "/versionInfo")
    public Mono<String> verionInfo() {
        return Mono.just("1.0.0");
    }

}
