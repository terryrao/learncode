package org.raowei.test.pattern.responsibilechan;

/**
 * 责任链处理类接口
 *
 * @author raow
 * @version 2015-08-28
 * @since 1.0
 * Copyright ©   e路同心（www.88bank.com）  All right reserved
 */
public interface Handler {

    void setHandler(Handler handler);


    void handler(String user, double fee);

    Handler getHandler();
}
