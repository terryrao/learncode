package org.raowei.test.cryptography;

/**
 * ${DESCRIPTION}
 * create: 2017-02-16 11:30
 *
 * @author admin
 */
public class Utils {

    private static String digists = "0123456789abcdef";
    public static String toHex(byte[] data,int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int v = data[i] & 0xFF;

            sb.append(digists.charAt(v >> 4));
            sb.append(digists.charAt(v& 0xF));
        }
        return sb.toString();
    }

    public static String toHex(byte[] data) {
        return toHex(data,data.length);
    }

    public static void main(String[] args) {
//        byte i =  -1;
//        int b = i&0xff;
//        System.out.println(i);
//        System.out.println(b);

        System.out.println(bytes2HexString(new byte[] {-1}));
    }

    public static String bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[ i ] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }
}
