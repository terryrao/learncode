package org.raowei.test.concurrents.stop;

public class UnsafeStop {
    public static User u = new User();


    public static class User {
        int id = 0;
        String name = "0";

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "user[ id=" + id + ", name= " + name +  "]";
        }
    }

    static class ChangeObjectThread extends  Thread {

        @Override
        public void run() {

            while (true) {
                synchronized (u) {
                    int v = (int)(System.currentTimeMillis() / 1000);
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    if (!Integer.valueOf(u.getId()).equals(Integer.valueOf(u.getName()))) {
                        System.out.println(u);
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new ReadObjectThread().start();
        while (true ) {
            ChangeObjectThread changeObjectThread = new ChangeObjectThread();
            changeObjectThread.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            changeObjectThread.stop();
        }
    }
}
