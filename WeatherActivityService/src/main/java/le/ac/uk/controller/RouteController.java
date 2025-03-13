package le.ac.uk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import le.ac.uk.model.Route;
import le.ac.uk.model.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class RouteController {

    public Route getRouteInfo(double lat, double lon) throws JsonProcessingException {
        String apiKey = "83810fc651b64003bc08dd4f5e7cf722";

        // starting point is University of Leicester
        String apiUrl = "https://api.geoapify.com/v1/routing?waypoints=52.6369,-1.1398|"+lat+","+lon+"&mode=drive&apiKey="+apiKey+"&units=imperial";

        RestTemplate restTemplate = new RestTemplate();
        String apiResponse = restTemplate.getForObject(apiUrl, String.class);

        // Parse JSON response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(apiResponse);

        Route route = new Route();

        // Extract data from API response
        route.setDistance(root.path("features").get(0).path("properties").path("distance").asDouble());
        route.setEstimatedTime(root.path("features").get(0).path("properties").path("time").asDouble()/3600);

        return route;
    }
}
