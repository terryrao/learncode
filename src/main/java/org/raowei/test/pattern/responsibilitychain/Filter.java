package org.raowei.test.pattern.responsibilitychain;

/**
 * @author terryrao on 2016/7/23.
 */
@FunctionalInterface
public interface Filter {

    void doFilter(Request request,Response response);
}
