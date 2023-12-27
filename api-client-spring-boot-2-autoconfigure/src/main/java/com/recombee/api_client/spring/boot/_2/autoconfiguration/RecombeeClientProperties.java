package com.recombee.api_client.spring.boot._2.autoconfiguration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.recombee.api_client.util.Region;

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
