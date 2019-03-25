package org.raowei.test;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ${DESCRIPTION}
 * create: 2017-03-31 10:05
 *
 * @author admin
 */
public class TestClass {

    Map<String,String> map = new ConcurrentHashMap<>();
    Object o = new Object();
    @Test
    public void TestReturn() {
        // 。。。
        int a;
        System.out.println(a = 4);

        String ab = "";
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(objectObjectHashMap.put("1","2"));
        System.out.println(objectObjectHashMap.put("1","2"));


        System.out.println(1 << 30);
        System.out.println(1073741824 >>> 16);
        System.out.println(16384 >>>14);

        System.out.println(1^2);
    }



    public static void main(String[] args) throws Exception {
        int bufSize = 1024;
        byte[] bs = new byte[bufSize];
        ByteBuffer byteBuf = ByteBuffer.allocate(1024);
        FileChannel channel = new RandomAccessFile("d:\\filename","r").getChannel();
        while(channel.read(byteBuf) != -1) {
            int size = byteBuf.position();
            byteBuf.rewind();
            byteBuf.get(bs);
            // 把文件当字符串处理，直接打印做为一个例子。
            System.out.print(new String(bs, 0, size));
            byteBuf.clear();
        }
    }

    @Test
    public void testInteger() {
        System.out.println(127 == 127);
        System.out.println( new Integer(127) == new Integer(127));
        System.out.println( Integer.valueOf(127) == Integer.valueOf(127));
        System.out.println(129 == 129);
        System.out.println( new Integer(129) == new Integer(129));
        System.out.println( Integer.valueOf(129) == Integer.valueOf(129));
    }

    @Test
    public void testSwitch() {
        byte a = 2;
        switch (a) {
            case 1 :
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println("default");
        }
    }

    @Test
    public void testConcurrentHashMap() {

        int size = 20;
        ExecutorService service = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            service.execute(() -> {
                boolean is = false;
                synchronized (o){
                    is = "1".equals(map.get("key"));
                if (is) {
                    System.out.println("1");
                }else {
                    map.put("key","1");
                    System.out.println("设置为1");
                }
                }
            });
        }

        service.shutdown();

    }


    @Test
    public void testMulitply() {
        int i= 1,j = 1,k = 0;
        for (; j < 10 ; i++) {
            k = i*j;
            System.out.print(j + " * " + i + " = " + k + "\t ");
            if (i > j && k <= 81) {
                System.out.println();
                i = 0;
                j++;
            }
        }

    }


    @Test
    public void testHourOfDay() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateUtils.parseDate("2017-04-13 00:00:00","yyyy-MM-dd HH:mm:ss"));
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(time);
        System.out.println(format);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }


    @Test
    public void testGaussian() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(gaussian(100,10));
        }
    }

    private double gaussian(int a, int b ) {
        return Math.sqrt(b) * (new Random().nextGaussian()) + a;
    }





}




