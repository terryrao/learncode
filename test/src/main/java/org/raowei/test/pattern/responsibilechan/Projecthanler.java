package org.raowei.test.pattern.responsibilechan;

/**
 * @author raow
 * @version 2015-08-28
 * @since 1.0
 * Copyright ©   e路同心（www.88bank.com）  All right reserved
 */
public class Projecthanler implements Handler {
    private Handler handler;

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handler(String user, double fee) {
        Handler handler = this.getHandler();
        System.out.println("project handler");
        if ("myself".equals(user) && fee < 100) {
            System.out.println("我自己处理了");
        }else{
            if (handler == null)
                throw new IllegalArgumentException("没有处理对象 handler is null");
            handler.handler(user,fee);
        }

    }

    @Override
    public Handler getHandler() {
        return this.handler;
    }

}
