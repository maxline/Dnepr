package org.maxline.timeVerifier;

import org.apache.log4j.Logger;
import org.junit.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for timeVerifier app.
 */
public class StartTimeVerifierTest {
    private static Logger LOG = Logger.getLogger(StartTimeVerifierTest.class.getName());
    private static final Map<Time, Time.PartOfDay> getPartOfDayData = new HashMap<Time, Time.PartOfDay>();
    private static Time time;

    @BeforeClass
    public static void init() {
        LOG.debug("------------------------------------------");
        LOG.debug("init() invoked");

        getPartOfDayData.put(new Time(2, 1), Time.PartOfDay.NIGHT);
        getPartOfDayData.put(new Time(6, 1), Time.PartOfDay.MORNING);
        getPartOfDayData.put(new Time(10, 1), Time.PartOfDay.DAY);
        getPartOfDayData.put(new Time(19, 1), Time.PartOfDay.EVENING);

        time = StartTimeVerifier.getCurrentTime();
        LOG.debug("init() exit\n");
    }

    @AfterClass
    public static void tearDown() {
        LOG.debug("tearDown() invoked");

        getPartOfDayData.clear();
        time = null;

        LOG.debug("tearDown() exit");
        LOG.debug("------------------------------------------\n");
    }

    @Test
    public void testPartOfDay() {
        LOG.debug("testPartOfDay() invoked");

        for (Map.Entry<Time, Time.PartOfDay> entry : getPartOfDayData.entrySet()) {
            final Time testData = entry.getKey();
            final Time.PartOfDay expected = entry.getValue();
            final Time.PartOfDay actual = testData.getPartOfDay();
            assertEquals(expected, actual);
        }

        LOG.debug("testPartOfDay() exit");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWrongHour() {
        LOG.debug("testWrongHour() invoked");

        new Time(25, 1);

        LOG.debug("testWrongHour() exit");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testWrongMinute() {
        LOG.debug("testWrongMinute() invoked");

        new Time(12, -1);

        LOG.debug("testWrongMinute() exit");
    }


    @Test
    public void testWelcomeMessage() {
        LOG.debug("testWelcomeMessage() invoked");

        StartTimeVerifier.printWelcomeMessage(time, Locale.US);
        StartTimeVerifier.printWelcomeMessage(time, Locale.CHINA);
        StartTimeVerifier.printWelcomeMessage(time, new Locale("ru", "RU"));

        LOG.debug("testWelcomeMessage() exit");
    }
}
