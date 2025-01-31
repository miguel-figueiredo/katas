package com.example.shopping.spring.config;

import com.example.shopping.purchase.adapter.in.rest.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(UserResource.class);
	}

}