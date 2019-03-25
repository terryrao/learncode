/*
 * Copyright (c) 2015. [${USER}]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.raowei.test.concurrents.shareresources;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author terryrao
 * @version 1.0 6/9/2015 4:01 PM
 */
public class Interrupting {
    private static ExecutorService service = Executors.newCachedThreadPool();
    private static void test(Runnable r) throws InterruptedException {
        Future<?> f = service.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt set to " + r.getClass().getName());
    }

//    public static void main(String[] args) throws InterruptedException {
//        test(new SleepBlocked());
//        test(new IOBlocak(System.in));
//        test(new SynchronizedBlocked());
//        System.out.println("aborting with system.exit()");
//    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost",8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = executorService.submit(new NIOBlock(sc1));
        executorService.execute(new NIOBlock(sc2));
        executorService.shutdown();
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();


    }

}

class SleepBlocked implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exit sleepBlocak.run()");
    }
}

class IOBlocak implements  Runnable {
    private InputStream io;

    public IOBlocak(InputStream io) {
        this.io = io;
    }

    @Override
    public void run() {
        System.out.println("Waiting for read()");
        try {
            io.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked i/o");
            }else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exit IOBlocak.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.run();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exit SynchronizedBlocked.run()");
    }
}

class NIOBlock implements Runnable{
    private final SocketChannel sc ;

    public NIOBlock(SocketChannel sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        System.out.println("Wating for read() in " + this);
        try {
            sc.read(ByteBuffer.allocate(1));
        } catch (ClosedByInterruptException e) {
            System.out.println("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            System.out.println("AsynchronousCloseException");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
