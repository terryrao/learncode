package org.raowei.test.IO;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author raowei
 * @date 2019-06-06
 */
public class GenerateCharacter {

    public static  void genreateChater(OutputStream outputStream) throws IOException {
        int first = 33;
        int number = 94;
        int numberOfcharacterPerLine = 72;

        int start = first;
        while (true)  {
            for (int i = start; i < start + numberOfcharacterPerLine; i++) {
                outputStream.write(((i - first) %number)  +  first);
                outputStream.write('\r');
                outputStream.write('\n');
            }
        }
    }
}
