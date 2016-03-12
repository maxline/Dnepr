package org.maxline.timeVerifier;

import org.apache.log4j.Logger;

/**
 * The class Time creates Time object for the the necessary data for the timeverifier
 * application. It can define a part of day (morning, day, evening, night) by its hours
 * and minutes.
 *
 * @author Maxline.
 */
public class Time {
    public static final int MAX_HOUR = 23;
    public static final int MAX_MINUTE = 59;

    public enum PartOfDay {NIGHT, MORNING, DAY, EVENING}

    private static Logger LOG = Logger.getLogger(Time.class.getName());

    private int hour;
    private int minute;
    private PartOfDay partOfDay;

    public static final int START_MORNING = 6;
    public static final int START_DAY = 9;
    public static final int START_EVENING = 19;
    public static final int START_NIGHT = 23;

    public Time(int hh, int mm) {
        if (hh < 0 || hh > MAX_HOUR) {
            throw new IllegalArgumentException();
        }
        if (mm < 0 || mm > MAX_MINUTE) {
            throw new IllegalArgumentException();
        }

        hour = hh;
        minute = mm;
        definePartOfDay();
    }

    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    public PartOfDay getPartOfDay() {
        return partOfDay;
    }

    public void definePartOfDay() {
        LOG.debug("definePartOfDay() invoked");
        if (hour >= START_NIGHT || hour < START_MORNING) {
            partOfDay = PartOfDay.NIGHT;

        } else if (hour >= START_EVENING) {
            partOfDay = PartOfDay.EVENING;

        } else if (hour >= START_DAY) {
            partOfDay = PartOfDay.DAY;

        } else if (hour >= START_MORNING) {
            partOfDay = PartOfDay.MORNING;
        }

        LOG.info("Time = " + this + ", PartOfDay = (" + partOfDay + ")");
        LOG.debug("definePartOfDay() exit");
    }
}
