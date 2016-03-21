package org.maxline.timeVerifier;

import org.apache.log4j.Logger;
import java.util.*;

/**
 * The class PartOfDayVerifier contains main method and starts running the timeverifier
 * application.
 * <p/>
 * The result of executing application is message that depends on current times of day:
 * Good morning, World! from 06:00 - 09:00
 * Good day, World! from 09:00 - 19:00
 * Good evening, World! from 19:00 - 23:00
 * Good night, World! from 23:00 - 06:00
 *
 * @author Maxline.
 */
public class PartOfDayVerifier {
    private static Logger LOG = Logger.getLogger(PartOfDayVerifier.class.getName());

    public static PartOfDay getPartOfDay(Calendar calendar) {
        LOG.debug("getPartOfDay() invoked");

        String sTime = String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
        LOG.info("Current time = " + sTime);
        LOG.debug("getPartOfDay() exit");
        return new PartOfDay(calendar);
    }

    public static void printWelcomeMessage(PartOfDay partOfDay, Locale currentLocale) {
        LOG.debug("printWelcomeMessage() invoked");
        ResourceBundle messageBundle = ResourceBundle.getBundle("MessageBundle", currentLocale);
        String welcomeMessage = messageBundle.getString(partOfDay.getePartOfDay().toString());

        System.out.println(welcomeMessage);
        LOG.info("welcomeMessage =(" + welcomeMessage + ")");
        LOG.debug("printWelcomeMessage() exit");
    }

    public static void main(String[] args) {
        LOG.debug("-----------------------------------------------------");
        LOG.debug("main() invoked");

        Calendar currentTime = new GregorianCalendar();
        currentTime.setTimeZone(TimeZone.getTimeZone("GMT+02:00"));

        PartOfDay partOfDay = getPartOfDay(currentTime);
        Locale currentLocale = Locale.getDefault();
        printWelcomeMessage(partOfDay, currentLocale);

        LOG.debug("main() exit");
        LOG.debug("-----------------------------------------------------\n");
    }
}
