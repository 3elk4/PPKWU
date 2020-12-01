package com.mobcal.mobcal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WEEIAMonthCalendar {
    private String calendarId = "kalendarz";
    private String weekId = "dzien";
    private String tagId = "a";

    private int year, month;

    public WEEIAMonthCalendar(int year, int month){
        this.year = year;
        this.month = month;
    }

    public List<Element> GenerateMonthData() {
        List<Element> daysData = new ArrayList<>();

        try{
            Document doc = Jsoup.connect(URL()).get();
            Element calendar = doc.getElementById(calendarId);
            for (Element week : calendar.getElementsByClass(weekId)) {
                daysData.addAll(week.getElementsByTag(tagId));
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return daysData;
    }

    private String URL() {
        return "http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + year + "&miesiac=" + String.format("%02d", month);
    }
}
