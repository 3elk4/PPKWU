package com.mobcal.mobcal;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import org.jsoup.nodes.Element;
import java.util.List;

public class ICSCreator {
    List<Element> days;
    int year, month;

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

        return calendar;
    }
}
