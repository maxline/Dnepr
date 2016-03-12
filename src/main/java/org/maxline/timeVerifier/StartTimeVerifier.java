package org.maxline.timeVerifier;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * The class Start contains main method and starts running the timeverifier
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
public class StartTimeVerifier {
    private static Logger LOG = Logger.getLogger(StartTimeVerifier.class.getName());

    public static Time getTime(int hh, int mm) {
        return new Time(hh, mm);
    }

    public static Time getCurrentTime() {
        LOG.debug("getCurrentTime() invoked");
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+02:00"));
        LOG.info("calendar.get(Calendar.HOUR) = (" + calendar.get(Calendar.HOUR_OF_DAY) + ")");
        LOG.info("calendar.get(Calendar.MINUTE) = (" + calendar.get(Calendar.MINUTE) + ")");

        LOG.debug("getCurrentTime() exit");
        return getTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
    }

    public static void printWelcomeMessage(Time time, Locale currentLocale) {
        LOG.debug("printWelcomeMessage() invoked");
        ResourceBundle messageBundle = ResourceBundle.getBundle("MessageBundle", currentLocale);
        String welcomeMessage = messageBundle.getString(time.getPartOfDay().toString());

        System.out.println(welcomeMessage);

        LOG.info("welcomeMessage =(" + welcomeMessage + ")");
        LOG.debug("printWelcomeMessage() exit");
    }

    public static void main(String[] args) {
        LOG.debug("-----------------------------------------------------");
        LOG.debug("main() invoked");

        Time time = getCurrentTime();
        Locale currentLocale = Locale.getDefault();
        printWelcomeMessage(time, currentLocale);

        LOG.debug("main() exit");
        LOG.debug("-----------------------------------------------------\n");
    }
}
