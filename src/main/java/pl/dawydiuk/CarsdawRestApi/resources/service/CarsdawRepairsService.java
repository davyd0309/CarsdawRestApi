package pl.dawydiuk.CarsdawRestApi.resources.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class CarsdawRepairsService {

    private static final Logger log = LoggerFactory.getLogger(CarsdawRepairsService.class);
    private RestTemplate restTemplate;

    public ResponseEntity<String> getAllCarRepairs() {
        String fooResourceUrl
                = "http://localhost:8081/repairs";
        log.info("Module with repairs called");
        return restTemplate.exchange(fooResourceUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class);


    }

}
