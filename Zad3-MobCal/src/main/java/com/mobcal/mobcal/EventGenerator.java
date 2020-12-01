package com.mobcal.mobcal;

import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import org.jsoup.nodes.Element;

public class EventGenerator {

    public static CalendarComponent Generate(Element day, int month, int year){
        String name = day.getElementsByClass("InnerBox").text();
        int dayNumber = Integer.parseInt(day.getElementsByTag("a").text());
        VEvent event = new VEvent(CreateEventStart(dayNumber, month, year), name);
        return event;
    }

    private static Date CreateEventStart(int day, int month, int year){
        return new Date();
    }
}
