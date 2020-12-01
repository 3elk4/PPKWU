package com.mobcal.mobcal;

import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import org.jsoup.nodes.Element;

import java.util.Calendar;

public class EventGenerator {
    private static Calendar cal = java.util.Calendar.getInstance();

    public static CalendarComponent Generate(Element day, int month, int year){
        String name = day.getElementsByClass("InnerBox").text();
        int dayNumber = Integer.parseInt(day.getElementsByTag("a").text());
        VEvent event = new VEvent(CreateEventStart(dayNumber, month, year), name);
        return event;
    }

    private static Date CreateEventStart(int day, int month, int year){
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month-1); //because calendar in java.util starts from 0
        cal.set(Calendar.YEAR, year);
        cal.setTimeZone(TimeZone.getDefault());

        return new Date(cal.getTime());
    }
}
