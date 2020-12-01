package com.mobcal.mobcal;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Month;
import java.util.List;

public class ICSCreator {
    private final String directoryName = "calfiles/";
    private List<Element> days;
    private int year, month;

    public ICSCreator(List<Element> days, int month, int year){
        this.days = days;
        this.month = month;
        this.year = year;
    }

    public Calendar GenerateCalendarData(){
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//Ben Fortuna//iCal4j 1.0//EN"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);

        days.forEach(day -> {
            if(day.hasClass("active")){
                calendar.getComponents().add(EventGenerator.Generate(day, month, year));
            }
        });

        return calendar;
    }

    public String GenerateICSFile(Calendar calendar){
        String calendarName = CreateCalendarName();
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(directoryName + calendarName);
            CalendarOutputter outputter = new CalendarOutputter();
            outputter.output(calendar, fout);
        } catch (Exception e) {
            return null;
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return calendarName;
    }

    private String CreateCalendarName(){
        return StringUtils.capitalize(Month.of(month).name().toLowerCase()) + "_" + year + ".ics";
    }
}
