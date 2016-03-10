package org.maxline.timeverifier;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

/**
 * Unit test for simple App.
 */
public class StartTest
{
        @Test
        public void testApp() {
            assert  new Time(23, 01).getPartOfDay() == Time.PartOfDay.NIGHT;
            assert  new Time(2, 01).getPartOfDay() == Time.PartOfDay.NIGHT;
            assert  new Time(06, 01).getPartOfDay() == Time.PartOfDay.MORNING;
            assert  new Time(10, 01).getPartOfDay() == Time.PartOfDay.DAY;
            assert  new Time(19, 01).getPartOfDay() == Time.PartOfDay.EVENING;

            assert  new Time(100, 01 ).getPartOfDay() == Time.PartOfDay.NIGHT;
            assert  new Time(12, -01 ).getPartOfDay() == Time.PartOfDay.DAY;

            Time time = Start.getCurrentTime();

            Start.printWelcomeMessage(time, Locale.US);
            Start.printWelcomeMessage(time, Locale.CHINA);
            Start.printWelcomeMessage(time, new Locale("ru", "RU"));

        }
}
