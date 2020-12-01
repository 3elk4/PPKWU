package com.mobcal.mobcal;

import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.util.RandomUidGenerator;
import net.fortuna.ical4j.util.UidGenerator;
import org.jsoup.nodes.Element;

import java.util.Calendar;

public class EventGenerator {
    private static final Calendar cal = java.util.Calendar.getInstance();
    private static final String TitleClassName = "InnerBox";
    private static final String DayTagName = "a";
    private static UidGenerator ug = new RandomUidGenerator();

    public static CalendarComponent Generate(Element day, int month, int year){
        VEvent event = new VEvent(CreateEventStart(Day(day), month, year), Name(day));
        event.getProperties().add(ug.generateUid());
        return event;
    }

    private static Date CreateEventStart(int day, int month, int year){
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.MONTH, month-1); //because calendar in java.util starts from 0
        cal.set(Calendar.YEAR, year);
        cal.setTimeZone(TimeZone.getDefault());

        return new Date(cal.getTime());
    }

    private static int Day(Element day){
        return Integer.parseInt(day.getElementsByTag(DayTagName).text());
    }
    private static String Name(Element day){
        return day.getElementsByClass(TitleClassName).text();
    }
}
