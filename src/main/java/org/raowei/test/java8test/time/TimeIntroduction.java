package org.raowei.test.java8test.time;

import java.time.Clock;
import java.time.ZoneId;

/**
 * Created by terryrao on 5/15/2015.
 */
public class TimeIntroduction {
    public static void testClock(){
        Clock c1 = Clock.systemUTC();
        System.out.println(c1.millis());
        System.out.println(c1.systemDefaultZone());

        Clock c2 = Clock.system(ZoneId.of("Europe/Paris"));
        System.out.println(c2.systemUTC());


    }

}
