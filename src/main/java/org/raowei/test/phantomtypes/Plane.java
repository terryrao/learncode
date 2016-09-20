package org.raowei.test.phantomtypes;

/**
 * ${DESCRIPTION}
 * create: 2016-09-20 17:35
 *
 * @author admin
 */
public class Plane<Status extends FlightStatus> {
    private Plane() {}

    public Plane(Plane<? extends FlightStatus> p) {

    }

    public static Plane<Landed> newPlane() {
        return new Plane<>();
    }
}
