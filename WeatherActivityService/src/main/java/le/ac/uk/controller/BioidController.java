package le.ac.uk.controller;

import le.ac.uk.entity.Bioid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bioid")
public class BioidController {


    @GetMapping("/test")
    public Bioid test() {
        Bioid bioid = new Bioid();
        bioid.setCode("aaa");
        bioid.setUsed(110);
        return bioid;
    }







}
