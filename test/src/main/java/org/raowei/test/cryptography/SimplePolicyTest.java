package org.raowei.test.cryptography;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * ${DESCRIPTION}
 * create: 2017-02-15 16:53
 *
 * @author admin
 */
public class SimplePolicyTest {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] data = new byte[]{0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07};
        System.out.println(data.length);
        //create secret key
        SecretKey key64 = new SecretKeySpec(new byte[]{0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07},"Blowfish");
        //create cipher

        Cipher cipher = Cipher.getInstance("Blowfish/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE,key64);
        System.out.println(Arrays.toString(cipher.doFinal(data)));
        System.out.println("64 bit test :passed");

        // create secret key 192

        SecretKey key192 = new SecretKeySpec(new byte[]{
                0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
                0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f,
                0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17
        },"Blowfish");

        //create cipher
        cipher.init(Cipher.ENCRYPT_MODE,key192);
        cipher.doFinal(data);
        System.out.println("192 bit test: passed");




    }

}
