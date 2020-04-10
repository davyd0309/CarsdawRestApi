package pl.dawydiuk.CarsdawRestApi.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawydiuk.CarsdawRestApi.resources.service.CarsdawRepairsService;

@RestController
@RequestMapping("/repairs")
public class CarsResources {

   private static final Logger log = LoggerFactory.getLogger(CarsResources.class);

    private CarsdawRepairsService carsdawRepairsService;

    public CarsResources(CarsdawRepairsService carsdawRepairsService) {
        this.carsdawRepairsService = carsdawRepairsService;
    }

    @GetMapping
    public ResponseEntity getAllRepairs() {
        log.info("Send RQ for all repairs");
        return carsdawRepairsService.getAllCarRepairs();
    }

}
