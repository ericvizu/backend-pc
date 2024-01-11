package com.ericvizu.backendpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BackendPcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPcApplication.class, args);
	}

}
