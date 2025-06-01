package com.example.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("student-info-service", r -> r.path("/api/student/**")
                        .uri("lb://student-info-service"))
                .route("grades-data-service", r -> r.path("/api/grade/**", "/api/course/**")
                        .uri("lb://grades-data-service"))
                .route("student-catalog-service", r -> r.path("/api/catalog/**")
                        .uri("lb://student-catalog-service"))
                .build();
    }
}
