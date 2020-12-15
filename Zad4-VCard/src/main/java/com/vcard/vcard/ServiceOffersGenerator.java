package com.vcard.vcard;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceOffersGenerator {
    private String companyListId = "company-list";
    private String companyNameId = "company-name";
    private String offerId = "li";

    private String URL(){
        return "https://panoramafirm.pl/szukaj?k=" + trade;
    }

    private String trade;
    public ServiceOffersGenerator(String trade){
        this.trade = trade;
    }

    public List<VCardModel> GenerateVCards(){
        List<VCardModel> vcardsData = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(URL()).get();
            Element offers = doc.getElementById(companyListId);
            for (Element offer : offers.getElementsByTag(offerId)) {
                System.out.println(offer.getElementsByClass(companyNameId).text());
//                VCardModel vcard = new VCardModel();
//                vcardsData.add(vcard);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return vcardsData;
    }
}
