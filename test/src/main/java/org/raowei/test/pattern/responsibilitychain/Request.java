package org.raowei.test.pattern.responsibilitychain;

/**
 * @author terryrao on 2016/7/23.
 */
public class Request {
    private String msg;

    public Request(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
