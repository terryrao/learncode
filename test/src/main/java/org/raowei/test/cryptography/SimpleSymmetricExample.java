package org.raowei.test.cryptography;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 对称加密
 * create: 2017-02-16 14:41
 *
 * @author admin
 */
public class SimpleSymmetricExample {

    static {
        try {
            Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
            field.setAccessible(true);
            field.set(null, java.lang.Boolean.FALSE);
        } catch (Exception ex) {
        }
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        byte[] input = new byte[]{
                0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77,
                (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb,
                (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff};
        byte[] keyBytes = new byte[]{
                0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
                0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f,
                0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17};
        SecretKey key = new SecretKeySpec(keyBytes,"AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
        System.out.println("input text : " + Utils.toHex(input));

        //encryption pass

        byte[] cipherText = new byte[input.length];
        cipher.init(Cipher.ENCRYPT_MODE,key);
        int length = cipher.update(input, 0, input.length, cipherText, 0);
        length += cipher.doFinal(cipherText,length);

        System.out.println("cipher text : " + Utils.toHex(cipherText) + " bytes: " + length);


        //decryption pass

        byte[] planText = new byte[length];
        cipher.init(Cipher.DECRYPT_MODE,key);
        int ptLength = cipher.update(cipherText,0,length,planText,0);
        ptLength += cipher.doFinal(planText,ptLength);

        System.out.println("plain text : " + Utils.toHex(planText)
                + " bytes: " + ptLength);

    }
}
