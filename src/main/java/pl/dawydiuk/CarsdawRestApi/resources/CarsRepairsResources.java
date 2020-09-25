package pl.dawydiuk.CarsdawRestApi.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawydiuk.CarsdawRestApi.service.CarsdawRepairsService;

@RestController
@RequestMapping("/repairs")
public class CarsRepairsResources {

   private static final Logger log = LoggerFactory.getLogger(CarsRepairsResources.class);

    private CarsdawRepairsService carsdawRepairsService;

    public CarsRepairsResources(CarsdawRepairsService carsdawRepairsService) {
        this.carsdawRepairsService = carsdawRepairsService;
    }

    @GetMapping
    public ResponseEntity getAllRepairs() {
        log.info("Send RQ for all repairs");
        return carsdawRepairsService.getAllCarRepairs();
    }

    @GetMapping
    @RequestMapping("/test")
    public ResponseEntity testQ() {
        log.info("Send RQ for test");
        return new ResponseEntity<>("Hello KONRAD Test!", HttpStatus.OK);
    }

}
