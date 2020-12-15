package com.vcard.vcard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VCardController {
    @GetMapping("/{trade}")
    public String getTrades(@PathVariable("trade") String trade) {
       ServiceOffersGenerator sog = new ServiceOffersGenerator(trade);
       sog.GenerateVCards();
       return "";
    }

}
