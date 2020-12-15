package com.vcard.vcard;

import ezvcard.VCard;
import ezvcard.property.Address;

public class VCardGenerator {
    public static VCard GenerateVcard(VCardModel model){
        VCard vcard = new VCard();
        vcard.addFormattedName();
        vcard.addEmail();
        vcard.addTelephoneNumber();
        vcard.addAddress();
        return vcard;
    }
}
