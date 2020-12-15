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
    private String addressId = "address";
    private String telephoneIconId = "icon-telephone";
    private String telephoneAttrId = "title";
    private String emailIconId = "icon-envelope";
    private String emailAttrId = "data-company-email";
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
                String company_name = offer.getElementsByClass(companyNameId).text();
                String address = offer.getElementsByClass(addressId).text();
                var phone = offer.getElementsByClass(telephoneIconId).first();
                if(phone != null){
                    System.out.println(phone.attr(telephoneAttrId));
                }

                var email = offer.getElementsByClass(emailIconId).first();
                if(email != null){
                    System.out.println(email.attr(emailAttrId));
                }
                System.out.println();
               // System.out.println(offer.getElementsByClass(emailIconId));
//                VCardModel vcard = new VCardModel();
//                vcardsData.add(vcard);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return vcardsData;
    }
}
