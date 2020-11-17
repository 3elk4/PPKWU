package com.mobcal.mobcal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarController {
    @GetMapping("/{year}/{month}")
    public String getMonthCalendar(@PathVariable("year") Integer year, @PathVariable("month") Integer month){
        WEEIAMonthCalendar wmc = new WEEIAMonthCalendar(year, month);
        return "";
    }
}
