package org.raowei.test.java8test.time;

import java.util.stream.Stream;

import static java.util.stream.Stream.concat;

/**
 * ${DESCRIPTION}
 * create: 2016-07-18 16:20
 *
 * @author admin
 */
public interface Performance {

    public String getName();

    public Stream<Artist> getMusicians();

    // TODO: test
    default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }

}