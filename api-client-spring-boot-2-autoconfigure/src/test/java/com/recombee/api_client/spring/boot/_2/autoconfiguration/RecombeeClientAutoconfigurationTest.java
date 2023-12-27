package com.recombee.api_client.spring.boot._2.autoconfiguration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.spring.boot._2.autoconfiguration.RecombeeClientAutoconfigurationTest.TestConfig;

@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
public class RecombeeClientAutoconfigurationTest {

    @Configuration
    @EnableAutoConfiguration
    public static class TestConfig {
    }

    @Autowired
    private RecombeeClient client;

    @Test
    public void testAutoConfigurationExecutes() {
	assertThat(client).isNotNull();
    }
}
