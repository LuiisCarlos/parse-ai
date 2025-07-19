package dev.luisworks.parse_ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/documents/get")
                        .uri("lb://document-service"))
                .route(r -> r
                        .path("/documents/upload")
                        .uri("lb://document-service"))
                .route(r -> r
                        .path("/ocr/extract")
                        .uri("lb://document-service"))
                .build();
    }

}
