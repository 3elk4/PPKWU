package com.mobcal.mobcal;

import net.fortuna.ical4j.model.Calendar;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalendarController {
    @GetMapping("/{year}/{month}")
    public String getMonthCalendar(@PathVariable("year") Integer year, @PathVariable("month") Integer month){
        WEEIAMonthCalendar wmc = new WEEIAMonthCalendar(year, month);
        List<Element> daysData = wmc.GenerateMonthData();
        ICSCreator creator = new ICSCreator(daysData, month, year);
        Calendar calendar = creator.GenerateCalendarData();
        return "Calendar created successfully!";
    }
}
