package le.ac.uk.controller;

import le.ac.uk.repository.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Map<String, Object> getCities() {
        // Fetch city list from repository
        List<Object[]> cityList = cityRepository.getCityList(); // Fetch grouped data

        // Prepare the JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("cities", cityList);

        return response; // Return as JSON automatically
    }
}