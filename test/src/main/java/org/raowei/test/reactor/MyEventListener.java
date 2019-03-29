package org.raowei.test.reactor;

import java.util.List;

/**
 * @author raowei
 * @date 2019-03-30
 */
public interface MyEventListener<T> {

    void onDataChunk(List<T> chunk);

    void processComplete();
}
