package com.springapi.charlogger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StringApiController {
    private String upperCase = "Big letters";
    private String lowerCase = "Small letters";
    private String digitCase = "Numbers";
    private String signCase = "Signs";

    @GetMapping("/{text}")
    public Map<String, Integer> getStringLog(@PathVariable("text") String text){
        Map<String, Integer> signs = new HashMap<String, Integer>();
        for (char sign : text.toCharArray()){
            if(Character.isUpperCase(sign)) signs.merge(upperCase, 1, Integer::sum);
            else if(Character.isLowerCase(sign)) signs.merge(lowerCase, 1, Integer::sum);
            else if(Character.isDigit(sign)) signs.merge(digitCase, 1, Integer::sum);
            else signs.merge(signCase, 1, Integer::sum);
        }
        return signs;
    }
}
