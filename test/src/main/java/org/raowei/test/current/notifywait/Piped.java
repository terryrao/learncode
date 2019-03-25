package org.raowei.test.current.notifywait;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 *
 */
public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader in = new PipedReader();
        writer.connect(in);
        Thread printThread = new Thread(new Print(in),"printThread");
        printThread.start();
        int receive;
        try {
            while ((receive = System.in.read()) != -1) {
                writer.write(receive);
            }
        }finally {
            writer.close();
        }

    }

    static class Print implements Runnable {
        private PipedReader reader;

        public Print(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException ignored) {
            }
        }
    }
}
