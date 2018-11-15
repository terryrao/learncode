package org.raowei.test.concurrents;

public class ThreadGroupTest implements Runnable {
    public static void main(String[] args) {
        ThreadGroup t = new ThreadGroup("testGroup");
        Thread a = new Thread(t, new ThreadGroupTest(),"th1");
        Thread b = new Thread(t, new ThreadGroupTest(),"th2");
        a.start();
        b.start();
        System.out.println(t.activeCount());
        t.list();
    }

    @Override
    public void run() {
        String getGroupAndName = Thread.currentThread().getThreadGroup().getName()
                + "--" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + getGroupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
