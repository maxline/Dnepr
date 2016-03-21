package org.maxline.timeVerifier;

import org.apache.log4j.Logger;
import org.junit.*;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for timeVerifier app.
 */
public class PartOfDayVerifierTest {
    private static Logger LOG = Logger.getLogger(PartOfDayVerifierTest.class.getName());
    private static final Map<Calendar, PartOfDay.ePartOfDay> getPartOfDayData = new HashMap<Calendar, PartOfDay.ePartOfDay>();

    private static Calendar getTime(int hh, int mm){
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+02:00"));

        calendar.set(Calendar.HOUR_OF_DAY, hh);
        calendar.set(Calendar.MINUTE, mm);

        return calendar;
    }

    @BeforeClass
    public static void init() {
        LOG.debug("------------------------------------------");
        LOG.debug("init() invoked");

        getPartOfDayData.put(getTime(2, 1), PartOfDay.ePartOfDay.NIGHT);
        getPartOfDayData.put(getTime(6, 1), PartOfDay.ePartOfDay.MORNING);
        getPartOfDayData.put(getTime(10, 1), PartOfDay.ePartOfDay.DAY);
        getPartOfDayData.put(getTime(19, 1), PartOfDay.ePartOfDay.EVENING);

        LOG.debug("init() exit\n");
    }

    @AfterClass
    public static void tearDown() {
        LOG.debug("tearDown() invoked");

        getPartOfDayData.clear();

        LOG.debug("tearDown() exit");
        LOG.debug("------------------------------------------\n");
    }

    @Test
    public void testPartOfDay() {
        LOG.debug("testPartOfDay() invoked");

        for (Map.Entry<Calendar, PartOfDay.ePartOfDay> entry : getPartOfDayData.entrySet()) {
            final Calendar testData = entry.getKey();
            final PartOfDay.ePartOfDay expected = entry.getValue();

            String sTime = String.format("%02d:%02d", testData.get(Calendar.HOUR_OF_DAY), testData.get(Calendar.MINUTE));
            LOG.info("Testing time = " + sTime);
            final PartOfDay.ePartOfDay actual = new PartOfDay(testData).getePartOfDay();
            assertEquals(expected, actual);
        }

        LOG.debug("testPartOfDay() exit\n");
    }

    @Test
    public void testWelcomeMessage() {
        LOG.debug("testWelcomeMessage() invoked");

        Calendar currentTime = new GregorianCalendar();
        currentTime.setTimeZone(TimeZone.getTimeZone("GMT+02:00"));
        PartOfDay partOfDay = PartOfDayVerifier.getPartOfDay(currentTime);

        PartOfDayVerifier.printWelcomeMessage(partOfDay, Locale.US);
        PartOfDayVerifier.printWelcomeMessage(partOfDay, Locale.CHINA);
        PartOfDayVerifier.printWelcomeMessage(partOfDay, new Locale("ru", "RU"));

        LOG.debug("testWelcomeMessage() exit");
    }
}
