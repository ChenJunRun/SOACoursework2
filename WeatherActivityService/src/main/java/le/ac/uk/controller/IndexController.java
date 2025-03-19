package le.ac.uk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // Loads the index page when visiting "/"
    @GetMapping("/")
    public String index() {
        return "index";  // This will load the index.html page
    }
}