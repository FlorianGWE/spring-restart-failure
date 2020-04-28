package com.example.spring.restart.testfailure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT //
        , properties = { "spring.jmx.enabled=true" } // needed for enabling RestartEndpoint (per default of in test)
)
class TestRestartFailureApplicationTests {

    @Test
    void contextLoads() {
    }

}
