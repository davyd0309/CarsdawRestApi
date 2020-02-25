package pl.dawydiuk.CarsdawRestApi.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dawydiuk.CarsdawModels.models.CarDto;


@RestController
@RequestMapping("/repairs")
public class CarsResources {

    @GetMapping
    public ResponseEntity getAllRepairs() {
        return new ResponseEntity(
                List.of(CarDto.builder().name("Volvo V50"),
                        CarDto.builder().name("Opel Astra J")), HttpStatus.FOUND);
    }

}
