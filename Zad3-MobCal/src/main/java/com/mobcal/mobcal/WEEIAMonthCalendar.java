package com.mobcal.mobcal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WEEIAMonthCalendar {
    private String url = "http://www.weeia.p.lodz.pl";
    private String calendarId = "kalendarz";
    private String weekId = "dzien";

    private int year, month;

    public WEEIAMonthCalendar(int year, int month){
        this.year = year;
        this.month = month;
    }

    public List<Element> GenerateMonthData() {
        List<Element> daysData = new ArrayList<>();

        try{
            Document doc = Jsoup.connect(url).get();
            Element calendar = doc.getElementById(calendarId);
            for (Element week : calendar.getElementsByClass(weekId)) {
                daysData.addAll(week.getElementsByTag("a"));
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return daysData;
    }
}
