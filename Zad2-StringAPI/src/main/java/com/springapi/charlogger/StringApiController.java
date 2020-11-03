package com.springapi.charlogger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StringApiController {

    @GetMapping("/{text}")
    public Map<Character, Integer> getStringLog(@PathVariable("text") String text){
        
    }
}
