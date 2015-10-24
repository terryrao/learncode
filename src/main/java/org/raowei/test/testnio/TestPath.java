package org.raowei.test.testnio;

import com.raowei.util.StringUtils;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by terryrao on 5/25/2015.
 */
public class TestPath {

    public static Path getPath(String path,String more) {
        if (StringUtils.isBlank(more)) {
            return FileSystems.getDefault().getPath(path);
        }
        return Paths.get(path,more);
    }

    public static Path relativeToAbsolute(Path path) {
        return path.toAbsolutePath();
    }


    public  static void main(String args[]) {
      /*  Path path = getPath("./test.text",null);
        path.toAbsolutePath(); // C:\Users\terryrao\Documents\GitHub\.\core\test.text
        path.normalize().toAbsolutePath(); //C:\Users\terryrao\Documents\GitHub\core\test.text
        try {
            path = path.toRealPath(); // if test.text is not exist throws an exception
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(path.toString());*/



    }
}
