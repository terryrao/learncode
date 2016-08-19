package org.raowei.test.util;

import java.util.concurrent.BlockingQueue;

/**
 * ${DESCRIPTION}
 * create: 2016-08-08 17:36
 *
 * @author admin
 */
public class BlockingQueueTest {

    class basker{
        BlockingQueue<Ball> queue;
    }


    class Ball {
        private int number;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

}
