package le.ac.uk.controller;

import le.ac.uk.model.City;
import le.ac.uk.repository.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @GetMapping("/list")
    public List<Object[]> getGroupedCityList() {
        return cityRepository.getCityList(); // Returns grouped data as Object[] arrays
    }
}

