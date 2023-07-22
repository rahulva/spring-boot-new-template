package com.example.demo.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/persons")
public class PersonController {

    @GetMapping("/test")
    String test() {
        return "Test!!";
    }

}
