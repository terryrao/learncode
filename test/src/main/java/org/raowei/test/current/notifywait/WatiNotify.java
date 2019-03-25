package org.raowei.test.current.notifywait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class WatiNotify {
   static boolean flag = false;

   static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notify = new Thread(new Notify(),"notifyThread");
        notify.start();
    }


   static class Wait implements Runnable {

       @Override
       public void run() {
           synchronized (lock) {
               while (flag) {
                   System.out.println(Thread.currentThread() + " flag is true . wait @ " +
                   new SimpleDateFormat("HH:mm:ss").format(new Date()));
                   try {
                       lock.wait();
                   } catch (InterruptedException ignored) {
                   }
               }

               System.out.println(Thread.currentThread() + "flag is false .run @" +
                       new SimpleDateFormat("HH:mm:ss").format(new Date()));
           }
       }
   }

   static  class Notify implements Runnable {

       @Override
       public void run() {
           synchronized (lock) {
               while (!flag) {
                   System.out.println(Thread.currentThread() + " thread is locked . notify @"
                    + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                   lock.notifyAll();
                   flag = true;
                   try {
                       TimeUnit.SECONDS.sleep(5);
                   } catch (InterruptedException ignored) {
                   }
               }
           }

           synchronized (lock) {
               System.out.println(Thread.currentThread() + " thread is locked . notify  again@"
                       + new SimpleDateFormat("HH:mm:ss").format(new Date()));
               try {
                   TimeUnit.SECONDS.sleep(5);
               } catch (InterruptedException ignored) {
               }
           }
       }
   }

}
