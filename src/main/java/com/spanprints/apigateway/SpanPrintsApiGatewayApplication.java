package com.spanprints.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpanPrintsApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpanPrintsApiGatewayApplication.class, args);
	}

}
