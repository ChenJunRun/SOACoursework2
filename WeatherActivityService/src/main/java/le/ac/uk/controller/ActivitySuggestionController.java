package le.ac.uk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import le.ac.uk.entity.activity.activity;
import le.ac.uk.model.Route;
import le.ac.uk.service.IActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/")
//public class activityController {
//
//    @Autowired
//    private activityDAO activity;
//
//    @GetMapping("/")
//    protected activityDAO getActivity() {
//        return activity;
//    }
//}


import le.ac.uk.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/suggestions")
public class ActivitySuggestionController {

    @PostMapping
    public String loadActivityPage(@RequestParam("city_list") String town, Model model) {
        model.addAttribute("town",town);
        return "activity";
    }

    @Autowired
    private WeatherController weatherController;

    @Autowired
    private RouteController routeController;

    @Autowired
    private IActivityService activityService;


    @GetMapping ("/list")
    @ResponseBody
    public Object getActivity(@RequestParam("town") String town) throws JsonProcessingException {

        String city=town.split(",")[0];
        String region=town.split(",")[1];

        Weather weather = weatherController.getWeather(city);
        boolean isSuitableForOutdoor = weatherController.checkWeather(weather);

        // Fetch activities based on suitability
        List<activity> activities = activityService.selectActivityByRegionAndType(city, isSuitableForOutdoor ? 1 : 0);

        // Prepare JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("city", city);
        response.put("cityregion", region);
        response.put("weather", weather);

        try{
            if(!activities.isEmpty()) {
                // Convert activities into a JSON-friendly format
                List<Map<String, Object>> activityList = new ArrayList<>();
                for (activity a : activities) {
                    Map<String, Object> activityMap = new HashMap<>();
                    activityMap.put("id", a.getId());
                    activityMap.put("activityName", a.getName());
                    activityMap.put("activityType", a.getType());
                    activityMap.put("activitySlots", a.getSlots());
                    activityMap.put("activityPrice", a.getPrice());
                    activityMap.put("ActivityTown", a.getTown());
                    activityMap.put("ActivityRegion", a.getRegion());
                    activityMap.put("ActivityLocationLatitude", a.getLatitude());
                    activityMap.put("ActivityLocationLongitude", a.getLongitude());
                    activityMap.put("ActivityLocationPostcode", a.getPostcode());


                    // Fetch route information
                    Route route = routeController.getRouteInfo(a.getLatitude(), a.getLongitude());
                    activityMap.put("ActivityRouteDistance", route.getDistance());
                    activityMap.put("ActivityRouteTime", route.getEstimatedTime());

                    // Add other activity fields as necessary
                    activityList.add(activityMap);
                    response.put("activities", activityList);
                }
            }
        }
        catch(Exception e){
            response.put("activities",null);
            response.put("message","Acivities are not available.");
        }



        return response; // Return JSON response

    }
}