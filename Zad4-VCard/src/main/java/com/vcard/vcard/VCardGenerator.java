package com.vcard.vcard;

import ezvcard.Ezvcard;
import ezvcard.VCard;
import ezvcard.property.Address;

import java.io.File;
import java.io.IOException;

public class VCardGenerator {
    public static VCard GenerateVCard(VCardModel model){
        VCard vcard = new VCard();
        vcard.addFormattedName();
        vcard.addEmail();
        vcard.addTelephoneNumber();
        vcard.addAddress();
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
}
