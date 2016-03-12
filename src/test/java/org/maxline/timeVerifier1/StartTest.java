package org.maxline.timeVerifier1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for timeVerifier app.
 */
public class StartTest {
    private static final Map<Time, Time.PartOfDay> getPartOfDayData = new HashMap<Time, Time.PartOfDay>();
    private Time time;

    @Before
    public void init() {
        getPartOfDayData.put(new Time(2, 01), Time.PartOfDay.NIGHT);
        getPartOfDayData.put(new Time(06, 01), Time.PartOfDay.MORNING);
        getPartOfDayData.put(new Time(10, 01), Time.PartOfDay.DAY);
        getPartOfDayData.put(new Time(19, 01), Time.PartOfDay.EVENING);

        getPartOfDayData.put(new Time(100, 01), Time.PartOfDay.NIGHT);
        getPartOfDayData.put(new Time(12, -01), Time.PartOfDay.DAY);

        time = Start.getCurrentTime();
    }

    @After
    public void tearDown() {
        getPartOfDayData.clear();
        time = null;
    }


//    @Rule
//    public TestWatcher watchman = new TestWatcher() {
//        @Override
//        protected void failed(Throwable e, Description description) {
//            super.failed(e, description);
//        }
//    }


    @Test
    public void testPartOfDay() {

        for (Map.Entry<Time, Time.PartOfDay> entry : getPartOfDayData.entrySet()) {
            final Time testData = entry.getKey();
            final Time.PartOfDay expected = entry.getValue();
            final Time.PartOfDay actual = testData.getPartOfDay();
            assertEquals(expected, actual);
        }


    }

    @Test
    public void testApp() {

        Start.printWelcomeMessage(time, Locale.US);
        Start.printWelcomeMessage(time, Locale.CHINA);
        Start.printWelcomeMessage(time, new Locale("ru", "RU"));

    }
}
