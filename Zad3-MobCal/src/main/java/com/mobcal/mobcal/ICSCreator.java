package com.mobcal.mobcal;
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
}
