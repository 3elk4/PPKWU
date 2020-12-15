package com.vcard.vcard;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.property.*;

import java.io.File;
import java.io.IOException;

public class VCardGenerator {
    public static VCard GenerateVCard(VCardModel model){
        VCard vcard = new VCard();

        vcard.addOrganization(PrepareCompanyName(model.CompanyName));
        vcard.addEmail(PrepareEmail(model.Email));
        vcard.addTelephoneNumber(PreparePhoneNumber(model.PhoneNumber));
        vcard.addAddress(PrepareAddress(model.Address));
        return vcard;
    }

    public static boolean GenerateVCF(VCard vcard, String name){
        String filename = CreateFileName(name);
        File file = new File(filename);
        try {
            Ezvcard.write(vcard).go(file);
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private static String CreateFileName(String name){
        return name + ".vcf";
    }

    private static Address PrepareAddress(String address){
        var result = new Address();
        result.setStreetAddress(address);
        return result;
    }

    private static Telephone PreparePhoneNumber(String phoneNumber){
        return new Telephone(phoneNumber);
    }

    private static Email PrepareEmail(String email){
        return new Email(email);
    }

    private static Organization PrepareCompanyName(String companyName){
        var org = new Organization();
        org.setSortAs(companyName);
        return org;
    }
}
