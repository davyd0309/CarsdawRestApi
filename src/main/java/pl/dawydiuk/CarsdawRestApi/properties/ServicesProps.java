package pl.dawydiuk.CarsdawRestApi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "services")
public class ServicesProps {

    @Setter
    @Getter
    private String carsdawRepairsService;
}
