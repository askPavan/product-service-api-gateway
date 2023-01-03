package com.ms.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApiGatewayApplication {
	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		System.out.println("Routing request to eureka-discovery-cleint-app from API GW:");
		return builder.routes().route("product", r -> r.path("/api/products/**").uri("lb://eureka-discovery-client-app")).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApiGatewayApplication.class, args);
	}

}
