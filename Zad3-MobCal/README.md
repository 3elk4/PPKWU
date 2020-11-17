## WEEIA Mobile Calendar - third exercise for PPKWU laboratories

This application prepares .ics file based on calendar information located at http://www.weeia.p.lodz.pl. Generated calendar for given year and month can be added to calendar on mobile device or google calendar.

#### Starting application

To start application, open in console folder src located in Zad3-MobCal folder. Then write down these two commands:

 1. javac main\java\com\mobcal\mobcal\MobcalApplication.java
 2. java MobcalApplication

#### Testing application

 Test application by opening web browser and putting address with proper parameters: 
 
 > localhost:8080/{year}/{month}

 Where parameters `year` and `month` define numbers of given year and month.

 Example:

 > localhost:8080/2020/5

 This address refers to May of 2020 year. Based on this information application processes calendar data from WEEIA website for specified month and year. Then calendar information are transmit on device as .ics file.