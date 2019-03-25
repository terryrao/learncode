package org.raowei.test.cryptography;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

/**
 * 测试 bouncy castle 是否安装成功
 * create: 2017-02-16 10:24
 *
 */
public class SimpleProviderTest {


    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        String providerName = "BC";

        if (Security.getProvider(providerName) == null) {
            System.out.println(providerName + " provider not installed");
        }else {
            System.out.println(providerName + " is installed");
        }

        /*Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println(provider.getName());
        }*/


        Cipher cipher = Cipher.getInstance("Blowfish/ECB/NoPadding");
        System.out.println(cipher.getProvider());
        cipher = Cipher.getInstance("Blowfish/ECB/NoPadding","BC");
        System.out.println(cipher.getProvider());

    }
    
    
}
