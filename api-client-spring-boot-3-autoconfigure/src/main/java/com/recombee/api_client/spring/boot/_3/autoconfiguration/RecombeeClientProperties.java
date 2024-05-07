package com.recombee.api_client.spring.boot._3.autoconfiguration;

import org.springframework.validation.annotation.Validated;

import com.recombee.api_client.util.Region;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Validated
public class RecombeeClientProperties {
    @NotBlank
    private String databaseId;
    @NotBlank
    private String token;
    @NotNull
    private Region region;

    public RecombeeClientProperties() {
	// empty no-args constructor
    }

    public RecombeeClientProperties(@NotBlank String databaseId, @NotBlank String token, @NotNull Region region) {
	this.databaseId = databaseId;
	this.token = token;
	this.region = region;
    }

    public String getDatabaseId() {
	return databaseId;
    }

    public void setDatabaseId(String databaseId) {
	this.databaseId = databaseId;
    }

    public String getToken() {
	return token;
    }

    public void setToken(String token) {
	this.token = token;
    }

    public Region getRegion() {
	return region;
    }

    public void setRegion(Region region) {
	this.region = region;
    }

}
