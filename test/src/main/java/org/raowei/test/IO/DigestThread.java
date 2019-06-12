package org.raowei.test.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author raowei
 * @date 2019-06-08
 */
public class DigestThread extends Thread{
    private File input;

    public DigestThread(File input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            FileInputStream inputStream = new FileInputStream(this.input);
            MessageDigest rsa = MessageDigest.getInstance("sha");
            DigestInputStream dis = new DigestInputStream(inputStream,rsa );
//            while (dis.read() != -1) ;
            dis.close();
            byte[] digest = rsa.digest();
            StringBuilder sb = new StringBuilder();
            sb.append(input.toString());
            sb.append(":");
            for (int i = 0; i < digest.length; i ++) {
                sb.append(digest[i]).append(" ");
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            new DigestThread(new File(args[i])).start();
        }
    }
}
