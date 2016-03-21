package org.maxline.timeVerifier;

import org.apache.log4j.Logger;

import java.util.Calendar;

/**
 * The class Time creates Time object for the the necessary data for the timeverifier
 * application. It can define a part of day (morning, day, evening, night) by its hours
 * and minutes.
 *
 * @author Maxline.
 */
public class PartOfDay {
    public enum ePartOfDay {NIGHT, MORNING, DAY, EVENING}

    private static Logger LOG = Logger.getLogger(PartOfDay.class.getName());

    private int hour;
    private ePartOfDay ePartOfDay;

    public static final int START_MORNING = 6;
    public static final int START_DAY = 9;
    public static final int START_EVENING = 19;
    public static final int START_NIGHT = 23;

    public PartOfDay(Calendar calendar) {
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        definePartOfDay();
    }

    public ePartOfDay getePartOfDay() {
        return ePartOfDay;
    }

    public void definePartOfDay() {
        LOG.debug("definePartOfDay() invoked");
        if (hour >= START_NIGHT || hour < START_MORNING) {
            ePartOfDay = ePartOfDay.NIGHT;

        } else if (hour >= START_EVENING) {
            ePartOfDay = ePartOfDay.EVENING;

        } else if (hour >= START_DAY) {
            ePartOfDay = ePartOfDay.DAY;

        } else if (hour >= START_MORNING) {
            ePartOfDay = ePartOfDay.MORNING;
        }

        LOG.info("Hour = " + hour + ", PartOfDay = (" + ePartOfDay + ")");
        LOG.debug("definePartOfDay() exit");
    }
}
