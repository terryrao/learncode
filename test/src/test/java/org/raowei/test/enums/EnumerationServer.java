package org.raowei.test.enums;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * create: 2016-07-29 9:24
 *
 * @author terryrao
 */
public class EnumerationServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket socketServer = new ServerSocket(8899);
        Socket socket = socketServer.accept();
        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        WeekDayEnum weekEnum = (WeekDayEnum) ois.readObject();
        if (weekEnum == WeekDayEnum.Fri) {
            System.out.println("client Friday enum value is same as server's ");
        }else if (weekEnum.equals(WeekDayEnum.Fri)) {
            System.out.println("client Friday enum value is equals to server's ");
        }else {
            System.out.println("client Friday enum value is not same as server's ");
        }

        // 用 switch 方式来比较枚举对象
        switch (weekEnum) {
            case Mon:
                System.out.println("Do Monday work");
                break;
            case Tue:
                System.out.println("Do Tuesday work");
                break;
            case Wed:
                System.out.println("Do Wednesday work");
                break;
            case Thu:
                System.out.println("Do Thursday work");
                break;
            case Fri:
                System.out.println("Do Friday work");
                break;
            case Sat:
                System.out.println("Do Saturday work");
                break;
            case Sun:
                System.out.println("Do Sunday work");
                break;
            default:
                System.out.println("I don't know which is day");
                break;
        }
        ois.close();
        is.close();
        socket.close();
    }
}
