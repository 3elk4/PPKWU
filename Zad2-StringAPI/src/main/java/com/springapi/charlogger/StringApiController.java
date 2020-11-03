package com.springapi.charlogger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StringApiController {

    @GetMapping("/{text}")
    public Map<Character, Integer> getStringLog(@PathVariable("text") String text){
        Map<Character, Integer> signs = new HashMap<Character, Integer>();
        for (char sign : text.toCharArray()){
            if(Character.isUpperCase(sign)) signs.merge('B', 1, Integer::sum);
            else if(Character.isLowerCase(sign)) signs.merge('L', 1, Integer::sum);
            else if(Character.isDigit(sign)) signs.merge('N', 1, Integer::sum);
            else signs.merge('S', 1, Integer::sum);
        }
        return signs;
    }
}
