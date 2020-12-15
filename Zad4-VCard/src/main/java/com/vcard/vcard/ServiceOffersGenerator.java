package com.vcard.vcard;

public class ServiceOffersGenerator {
    private String URL(){
        return "https://panoramafirm.pl/szukaj?k=" + trade;
    }

    private String trade;
    public ServiceOffersGenerator(String trade){
        this.trade = trade;
    }
}
