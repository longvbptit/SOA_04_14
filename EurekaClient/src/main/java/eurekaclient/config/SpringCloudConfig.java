package eurekaclient.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/thueoxy/**")
                        .uri("http://localhost:8002/")
                        )
                .route(r -> r.path("/donDangKy/**")
                        .uri("http://localhost:8080/")
                        )
                .route(r -> r.path("/oxy/**")
                        .uri("http://localhost:8025/")
                        )
                .route(r -> r.path("/benhvien/**")
                        .uri("http://localhost:8026/")
                        )
                .route(r -> r.path("/dondangky/**")
                        .uri("http://localhost:8027/")
                        )
                .route(r -> r.path("/notify/**")
                        .uri("http://localhost:8089/")
                        )

                .build();
    }
    
}