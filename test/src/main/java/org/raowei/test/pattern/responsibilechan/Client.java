package org.raowei.test.pattern.responsibilechan;

/**
 * @author raow
 * @version 2015-08-28
 * @since 1.0
 * Copyright ©   e路同心（www.88bank.com）  All right reserved
 */
public class Client {
    public static void main(String[] args) {
        Handler project = new Projecthanler();
        Handler manager  = new managerHandler();
        project.setHandler(manager);

        project.handler("myself", 105);
    }
}
