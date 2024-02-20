package nfcunha.sandbox.apigateway.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GatewayRouter {

    @Bean
    public RouteLocator getRouter(final RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(product -> product
                        .path("/product")
                        .uri("http://localhost:8081/product"))
                .route(supplier -> supplier
                        .path("/supplier")
                        .uri("http://localhost:8082/supplier"))
                .build();
    }

}
