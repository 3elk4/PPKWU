package com.vcard.vcard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VCardController {
    List<VCardModel> vcards = null;

    @GetMapping("/{trade}")
    public List<VCardModel> getTrades(@PathVariable("trade") String trade) {
       ServiceOffersGenerator sog = new ServiceOffersGenerator(trade);
       var vcards = sog.GenerateVCards();
       return vcards;
    }

    @GetMapping("/offers/{id}")
    public String generateVcf(@PathVariable("id") int id){
        if(vcards == null || vcards.isEmpty()) return "Oops! There was a problem to create VCF file.";

        var vCardModel = vcards.get(id);
        var vCard = VCardGenerator.GenerateVCard(vCardModel);
        if(!VCardGenerator.GenerateVCF(vCard, vCardModel.CompanyName)) return "Oops! There was a problem to create VCF file.";
        return "File was created successfully!";
    }

}
