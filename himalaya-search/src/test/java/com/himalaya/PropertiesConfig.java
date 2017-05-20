package com.himalaya;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("propertiesConfig")
public class PropertiesConfig {

    @Value("#{propertiesReader[host]}")
    private String host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
