package org.raowei.test.current.threadpool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 */
public class SimpleHttpServer {
    private static final ThreadPool<HttpRequestHandle>  pool = new DefaultThreadPool<>(10);
    private int port = 8080;
    private String basePath;

    public void setPort(int port) {
        this.port = port;
    }

    public void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            this.basePath = basePath;
        }
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(this.port);
            Socket accept;
            while ((accept = serverSocket.accept())!= null) {
                System.out.println("request accept");
                pool.execute(new HttpRequestHandle(accept,basePath));
            }
        } catch (IOException ignored) {
        }
    }

    /**
     *
     */

    static class  HttpRequestHandle implements Runnable{
        private String basePath;
        private Socket socket;

        HttpRequestHandle(Socket socket,String basePath) {
            this.socket = socket;
            this.basePath = basePath;
        }

        @Override
        public void run() {
            BufferedReader br = null;
            PrintWriter out = null;

            try {
                out = new PrintWriter(socket.getOutputStream());
                br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String s = br.readLine();
                String filePath = basePath + s.split(" ")[1];
                if (filePath.endsWith(".jpg")) {
                    FileInputStream fileInputStream = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i;
                    while ((i = fileInputStream.read())!= -1) {
                        baos.write(i);
                    }
                    byte[] byteArray = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: terryrao");
                    out.println("Content-Type: application/x-jpg");
                    out.println("content-length: " + byteArray.length);
                    socket.getOutputStream().write(byteArray, 0, byteArray.length);
                }else {
                    BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: terryrao");
                    out.println("Content-type: text/html;charset: utf-8");
                    out.println("");
                    String line ;
                    while ((line = read.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();

            } catch (IOException e) {
                out.println("HTTP/1.1 500");
                e.printStackTrace();
            }finally {
                close(out,br,socket);
            }

        }
    }

    private static void  close(Closeable ... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        simpleHttpServer.setPort(8080);
        simpleHttpServer.setBasePath("H:/test/");
        simpleHttpServer.startServer();
    }

}
