package pl.dawydiuk.CarsdawRestApi.service;

import java.net.SocketTimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CarsdawRepairsService {

    private static final Logger log = LoggerFactory.getLogger(CarsdawRepairsService.class);
    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "reliable")
    public ResponseEntity<String> getAllCarRepairs() {
        String fooResourceUrl
                = "http://localhost:8082/repairs";
        log.info("Module with repairs called");
        return restTemplate.exchange(fooResourceUrl, HttpMethod.GET, HttpEntity.EMPTY, String.class);
    }

    public ResponseEntity<String> reliable() {
        return new ResponseEntity<>("Service unavailable please try again", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
