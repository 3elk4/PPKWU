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
    private int pageNum = 1;

    private String URL(){
        return "https://panoramafirm.pl/" + trade + "/firmy," + pageNum + ".html";
    }

    private String trade;
    public ServiceOffersGenerator(){
    }
    public void SetProfession(String profession){ this.trade = profession; }
    private List<VCardModel> vcardsData = new ArrayList<>();

    public List<VCardModel> GenerateVCards(){
        try {
            for(int i = 1; i < 4; ++i){
                pageNum = i;
                Document doc = Jsoup.connect(URL()).get();
                Element offers = doc.getElementById(companyListId);
                for (Element offer : offers.getElementsByTag(offerId)) {
                    String company_name = offer.getElementsByClass(companyNameId).text();
                    String address = offer.getElementsByClass(addressId).text();

                    String phone_number = "";
                    String email = "";
                    var phone = offer.getElementsByClass(telephoneIconId).first();
                    if(phone != null) phone_number = phone.attr(telephoneAttrId);
                    var em = offer.getElementsByClass(emailIconId).first();
                    if(em != null) email = em.attr(emailAttrId);

                    VCardModel vcard = new VCardModel(company_name, phone_number, address, email);
                    if(!vcard.CompanyName.isEmpty()){
                        vcardsData.add(vcard);
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return vcardsData;
    }
}
