package com.mobcal.mobcal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class WEEIAMonthCalendar {
    private String url = "http://www.weeia.p.lodz.pl";
    private String calendarId = "kalendarz";

    private int year, month;

    public WEEIAMonthCalendar(int year, int month){
        this.year = year;
        this.month = month;
    }

    public void GenerateMonthData() throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element calendar = doc.getElementById(calendarId);
    }
}
