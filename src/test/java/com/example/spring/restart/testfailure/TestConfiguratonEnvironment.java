package com.example.spring.restart.testfailure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguratonEnvironment {

    @Bean
    //@ConditionalOnAvailableEndpoint
    @ConditionalOnMissingBean
    public RestartEndpoint restartEndpointWithoutIntegration() {
        return new RestartEndpoint();
    }

}
