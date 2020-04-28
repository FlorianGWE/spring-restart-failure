package com.example.spring.restart.testfailure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT //
        , properties = { "spring.jmx.enabled=true" } // needed for enabling RestartEndpoint (per default of in test)
)
public class ControllerTest {
    @Autowired
    private ApplicationContext context;

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp(ApplicationContext context) {
        webTestClient = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    @DisplayName("Version endpoint \"/versionInfo\"")
    void versionEndpoint() {
        EntityExchangeResult<byte[]> entityExchangeResult = this.webTestClient.get()
                .uri("/versionInfo")
                .exchange()
                .expectBody()
                .returnResult();

        assertAll(() -> assertEquals(200, entityExchangeResult.getRawStatusCode()), //
                  () -> assertEquals("1.0.0", new String(entityExchangeResult.getResponseBodyContent()))

        );

    }

}
