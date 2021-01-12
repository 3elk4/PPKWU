package com.vcard.vcard;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.property.*;

import java.io.File;
import java.io.IOException;

public class VCardGenerator {
    public static VCard GenerateVCard(VCardModel model){
        VCard vcard = new VCard();

        vcard.setStructuredName(PrepareName(model.CompanyName));
        vcard.addFormattedName(PrepareFormattedName(model.CompanyName));
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
        return name.replaceAll("\\s","") + ".vcf";
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

    private static FormattedName PrepareFormattedName(String companyName){
        return new FormattedName(companyName);
    }

    private static StructuredName PrepareName(String companyName){
        StructuredName structuredName = new StructuredName();
        structuredName.setFamily(companyName);
        return structuredName;
    }
}
