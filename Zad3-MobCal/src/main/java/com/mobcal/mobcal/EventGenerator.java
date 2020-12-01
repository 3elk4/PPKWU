package com.mobcal.mobcal;

import net.fortuna.ical4j.model.component.CalendarComponent;
import net.fortuna.ical4j.model.component.VEvent;
import org.jsoup.nodes.Element;

public class EventGenerator {

    public static CalendarComponent Generate(Element day, int month, int year){
        VEvent event = new VEvent();
        return event;
    }
}
