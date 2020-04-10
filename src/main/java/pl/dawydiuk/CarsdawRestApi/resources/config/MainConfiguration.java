package pl.dawydiuk.CarsdawRestApi.resources.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.dawydiuk.CarsdawRestApi.resources.service.CarsdawRepairsService;

import java.time.Duration;

@Configuration
public class MainConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setReadTimeout(Duration.ofSeconds(3L))
                .build();
    }

    @Bean
    public CarsdawRepairsService carsdawRepairsService(RestTemplate restTemplate) {
        return new CarsdawRepairsService(restTemplate);
    }
}
