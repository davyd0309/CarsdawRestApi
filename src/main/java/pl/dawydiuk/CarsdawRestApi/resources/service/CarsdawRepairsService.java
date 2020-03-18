package pl.dawydiuk.CarsdawRestApi.resources.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarsdawRepairsService {

    public ResponseEntity<String> getAllCarRepairs(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8081/repairs";
        return  restTemplate.getForEntity(fooResourceUrl, String.class);

    }

}
