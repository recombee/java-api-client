package com.recombee.api_client.spring.boot._2.autoconfiguration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.spring.boot._2.autoconfiguration.RecombeeClientAutoconfigurationTest.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles("test")
public class RecombeeClientAutoconfigurationTest {

    @Configuration
//    @SpringBootApplication
    @EnableAutoConfiguration
    public static class TestConfig {
    }

    @Autowired
    private RecombeeClient client;

    @Test
    public void testAutoConfigurationExecutes() {
	assertNotNull(client);
    }
}
