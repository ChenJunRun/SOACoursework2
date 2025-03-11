package le.ac.uk.controller;

import le.ac.uk.mapper.activityDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class activityController {

    @Autowired
    private activityDAO activity;

    @GetMapping("/")
    protected activityDAO getActivity() {
        return activity;
    }
}
