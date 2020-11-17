package com.mobcal.mobcal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WEEIAMonthCalendar {
    private String url = "http://www.weeia.p.lodz.pl";
    private String calendarId = "kalendarz";
    private String weekId = "dzien";

    private int year, month;

    public WEEIAMonthCalendar(int year, int month){
        this.year = year;
        this.month = month;
    }

    public String GenerateMonthData() {
        try{
            Document doc = Jsoup.connect(url).get();
            StringBuilder sb = new StringBuilder();
            Element calendar = doc.getElementById(calendarId);
            for (Element week : calendar.getElementsByClass(weekId)) {
                for(Element day : week.getElementsByTag("a")){
                    System.out.println(day);
                    sb.append(day.toString());
                }
            }
            return sb.toString();
        }catch(IOException e){
            return e.getMessage();
        }
    }
}
