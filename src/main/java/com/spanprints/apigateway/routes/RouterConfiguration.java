package com.spanprints.apigateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;

@Configuration
public class RouterConfiguration {

	@Bean
	RouteLocator configureRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("DemoService", r1 -> r1
						.path("/demo/**")//.and().method(HttpMethod.GET.toString())
						.filters(f -> f
								.addRequestHeader("Authorization", "Basic Json.Web.Token.fromBean")
								.addResponseHeader("custom-resp", "custom-resp-value"))
						.uri("lb://SpanPrintsDemoService"))
				.route("AuthService", r1 -> r1
						.path("/auth/**")
						.filters(f -> f.rewritePath("auth/(?<segment>.*)", "/${segment}"))
						.uri("lb://SpanPrintsAuthService"))
				.build();
	}
}
