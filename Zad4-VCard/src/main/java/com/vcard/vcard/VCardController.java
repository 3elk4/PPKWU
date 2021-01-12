package com.vcard.vcard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VCardController {
    private List<VCardModel> vcards = null;
    private ServiceOffersGenerator sog = new ServiceOffersGenerator();

    @GetMapping("/{trade}")
    public String getTrades(@PathVariable("trade") String trade) {
       sog.SetProfession(trade);
       vcards = sog.GenerateVCards();
       return WebsiteGenerator.GenerateWebsite(trade, vcards);
    }

    @GetMapping("/offers/{id}")
    public String generateVcf(@PathVariable("id") int id){
        if(vcards == null || vcards.isEmpty()) return error;

        var vCardModel = vcards.get(id);
        var vCard = VCardGenerator.GenerateVCard(vCardModel);
        if(!VCardGenerator.GenerateVCF(vCard, vCardModel.CompanyName)) return error;
        return success;
    }

    private String success = "File was created successfully!";
    private String error = "Oops! There was a problem to create VCF file.";
}
