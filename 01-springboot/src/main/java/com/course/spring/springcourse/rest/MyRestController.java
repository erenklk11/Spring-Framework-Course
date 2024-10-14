package com.course.spring.springcourse.rest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MyRestController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String liftWeights(){
        return "Lift some weights!";
    }

    @GetMapping("/shopping")
    public String goShopping(){
        return "I'm gonna go shop!";
    }
}
