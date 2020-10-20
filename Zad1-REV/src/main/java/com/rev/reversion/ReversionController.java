package com.rev.reversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReversionController {
    private StringBuilder sb = null;

    @GetMapping("/reversed/{text}")
    public String getReversed(@PathVariable("text") String text){
        sb = new StringBuilder(text);
        sb.reverse();
        return sb.toString();
    }
}
