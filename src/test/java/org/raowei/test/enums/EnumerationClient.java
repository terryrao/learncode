package org.raowei.test.enums;

import org.junit.Test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * enum 类跨虚拟机传输演示：单个虚拟机中enum是独一份，所以可以用== 判断是否相等
 * 但跨虚拟机传输后就会多出一份来 因此不能用== 来判断是否相等
 *  参考 <a href='https://www.ibm.com/developerworks/cn/java/j-lo-enum/'>Java 语言中 Enum 类型的使用介绍</a>
 * create: 2016-07-29 9:21
 *
 * @author terryrao
 */
public class EnumerationClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",8899));
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(WeekDayEnum.Fri);
        oos.close();
        outputStream.close();
        socket.close();
    }
}
