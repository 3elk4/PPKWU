package com.rev.reversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReversionController {
    @GetMapping("/reversed/{text}")
    public String getReversed(@PathVariable("text") String text){
        return "";
    }
}
