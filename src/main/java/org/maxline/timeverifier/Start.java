package org.maxline.timeverifier;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * The class Start contains main method and starts running the timeverifier
 * application.
 *
 * The result of executing application is message that depends on current times of day:
 * Good morning, World! from 06:00 - 09:00
 * Good day, World! from 09:00 - 19:00
 * Good evening, World! from 19:00 - 23:00
 * Good night, World! from 23:00 - 06:00
 *
 * @author Maxline.
 */
public class Start {
    private static Logger LOG = Logger.getLogger(Start.class.getName());

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) {
        LOG.debug("main() invoked");

        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+02:00"));
        LOG.debug("calendar.get(Calendar.HOUR) = (" + calendar.get(Calendar.HOUR) + ")");
        LOG.debug("calendar.get(Calendar.MINUTE) = (" +calendar.get(Calendar.MINUTE) + ")");

        Time time = new Time(calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE));
        System.out.println("Good " + time.getPartOfDay().toString().toLowerCase() + ", World!");

        LOG.debug("main() exit");
    }
}
