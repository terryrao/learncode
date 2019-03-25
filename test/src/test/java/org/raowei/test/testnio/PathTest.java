package org.raowei.test.testnio;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by terryrao on 5/26/2015.
 */
public class PathTest {

    @Test
    public void test1() {
        Path prefix = Paths.get("/core/");
        Path completePath = prefix.resolve("conf/application.properties");
        System.out.println(completePath);

    }

    @Test
    public void findFileInDirectory() {
        Path dir = Paths.get("E:\\p2pworkspace");
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir,"*"); //找出当前所有的properties文件
            Iterator<Path> iterator = stream.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
                System.out.println(path);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
