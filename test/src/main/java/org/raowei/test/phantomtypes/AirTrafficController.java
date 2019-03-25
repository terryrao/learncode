package org.raowei.test.phantomtypes;

/**
 * ${DESCRIPTION}
 * create: 2016-09-20 17:37
 *
 * @author admin
 */
public class AirTrafficController {

    public static Plane<Landed> land(Plane<Flying> p) {
        return new Plane<>(p);
    }

    public static Plane<Flying> takeOff(Plane<Landed> p) {
        return new Plane<>(p);
    }

    public static void main(String[] args) {
        Plane<Landed> p = Plane.newPlane();

        Plane<Flying> fly = takeOff(p);

        Plane<Landed> land = land(fly);

        // doesn't compile
//        Plane<Landed> reallyLanded = land(land);
//        Plane<Flying> reallyFlying = takeOff(fly);

    }
}
