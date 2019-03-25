package org.raowei.test.pattern.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author terryrao on 2016/7/23.
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        this.filters.add(filter);
        return this;
    }

    public void doFilter(Request request, Response response) {
        filters.stream().forEach(filter -> filter.doFilter(request, response));
    }

}
