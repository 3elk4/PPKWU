package com.vcard.vcard;

public class VCardModel {
    public String CompanyName;
    public String PhoneNumber;
    public String Address;
    public String Email;

    public VCardModel(String companyName, String phoneNumber, String address, String email){
        this.CompanyName = companyName;
        this.PhoneNumber = phoneNumber;
        this.Address = address;
        this.Email = email;
    }
}
