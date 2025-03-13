package le.ac.uk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import le.ac.uk.model.Weather;
import le.ac.uk.model.WeatherConstraints;
import le.ac.uk.repository.WeatherConstraintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Controller
public class WeatherController {

    public Weather getWeather(String city) throws JsonProcessingException {

        String apiKey = "e5b5d461857af027e557a5c1e7dcf015";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String apiResponse = restTemplate.getForObject(apiUrl, String.class);

        // Parse JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(apiResponse);

        Weather weather = new Weather();

        // Extract data from API response
        weather.setTemperature(root.path("main").path("temp").asDouble());
        weather.setPrecipitation(root.path("rain").path("1h").asDouble(0.0)); // Default 0 if no precipitation data
        weather.setWindspeed(root.path("wind").path("speed").asDouble());
        weather.setCondition(root.path("weather").get(0).path("description").asText());;


        return weather;
    }

    public boolean checkWeather(Weather weather) {

        WeatherConstraints constraints = new WeatherConstraints();

        if (weather != null) {

            if (weather.getTemperature() < constraints.getMinTemperature() || weather.getTemperature() > constraints.getMaxTemperature() ||
                weather.getWindspeed() < constraints.getMinWindSpeed() || weather.getWindspeed() > constraints.getMaxWindSpeed() ){

                if(weather.getPrecipitation()!=0.0) {
                    if(weather.getPrecipitation() < constraints.getMinPrecipitation() || weather.getPrecipitation() > constraints.getMaxPrecipitation()){
                        return false;
                    }
                }
                return false;
            }

        }
        return true;

    }
}