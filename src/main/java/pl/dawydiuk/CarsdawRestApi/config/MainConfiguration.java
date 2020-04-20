package pl.dawydiuk.CarsdawRestApi.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

import pl.dawydiuk.CarsdawRestApi.exception.CarRestApiErrorHandler;
import pl.dawydiuk.CarsdawRestApi.service.CarsdawRepairsService;

@Configuration
public class MainConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder,
                                     ResponseErrorHandler responseErrorHandler) {
        return restTemplateBuilder
                .errorHandler(responseErrorHandler)
//                .setReadTimeout(Duration.ofSeconds(3L))
                .build();
    }

    @Bean
    public ResponseErrorHandler responseErrorHandler() {
        return new CarRestApiErrorHandler();
    }

    @Bean
    public CarsdawRepairsService carsdawRepairsService(RestTemplate restTemplate) {
        return new CarsdawRepairsService(restTemplate);
    }
}
