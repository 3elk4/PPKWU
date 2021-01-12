package com.vcard.vcard;

import java.util.List;

public class WebsiteGenerator {
    public static String GenerateWebsite(String trade, List<VCardModel> models){
        StringBuilder sb = new StringBuilder();
        sb = sb.append("<html><body>").append("</body></html>").append("<h2> Results for: ").append(trade).append("</h2><hr/>")
                .append("<table class=\"table table-striped\"><thead><tr><th>Company Name</th><th>Address</th><th>Phone Number</th><th>Email</th><th>Generate VCard</th></tr></thead><tbody>");
        for (var model : models) {
            sb = sb.append("<tr><td>").append(model.CompanyName).append("</td><td>")
                                        .append(model.Address).append("</td><td>")
                                        .append(model.PhoneNumber).append("</td><td>")
                                        .append(model.Email).append("</td><td><a href=\"offers/")
                                        .append(models.indexOf(model)).append("\"> Generate </a></td></tr>");
        }
        return sb.append("</tbody></table>").toString();
    }
}
