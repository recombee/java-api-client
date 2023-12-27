package com.recombee.api_client.spring.boot._2.autoconfiguration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.recombee.api_client.RecombeeClient;

@AutoConfiguration
@ConditionalOnClass(RecombeeClient.class)
@ConditionalOnProperty(prefix = RecombeeClientAutoconfiguration.DEFAULT_RECOMBEE_CLIENT_PROPERTIES_PREFIX, name = "enabled", matchIfMissing = true)
public class RecombeeClientAutoconfiguration {

    public static final String DEFAULT_RECOMBEE_CLIENT_PROPERTIES_PREFIX = "com.recombee.client";

    @Bean
    @ConditionalOnMissingBean
    @ConfigurationProperties(DEFAULT_RECOMBEE_CLIENT_PROPERTIES_PREFIX)
    RecombeeClientProperties recombeeClientProperties() {
	return new RecombeeClientProperties();
    }

    @Bean
    @ConditionalOnMissingBean
    RecombeeClient recombeeClient(RecombeeClientProperties recombeeClientProperties) {
	return new RecombeeClient(recombeeClientProperties.getDatabaseId(),
		recombeeClientProperties.getToken()).setRegion(recombeeClientProperties.getRegion());
    }

}
