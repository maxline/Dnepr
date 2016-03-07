package org.maxline.timeverifier;

/**
 * The class Time creates Time object for the the necessary data for the timeverifier
 * application. It can define a part of day (morning, day, evening, night) by its hours
 * and minutes.
 *
 * @author Maxline.
 */

enum PartOfDay {
    NIGHT, MORNING, DAY, EVENING;
}

public class Time {
    private int hour;
    private int minute;
    private PartOfDay partOfDay;

    public static final int START_MORNING = 6;
    public static final int START_DAY = 9;
    public static final int START_EVENING = 19;
    public static final int START_NIGHT = 23;

    public Time(int hh, int mm) {
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
        if (hour >= START_NIGHT || hour < START_MORNING) {
            partOfDay = PartOfDay.NIGHT;

        } else if (hour >= START_EVENING) {
            partOfDay = PartOfDay.EVENING;

        } else if (hour >= START_DAY) {
            partOfDay = PartOfDay.DAY;

        } else if (hour >= START_MORNING) {
            partOfDay = PartOfDay.MORNING;
        }
    }
}
