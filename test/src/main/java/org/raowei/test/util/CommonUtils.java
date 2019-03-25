package org.raowei.test.util;

import java.io.InputStream;

/**
 * 测试用简单工具类
 * create: 2016-08-30 17:57
 *
 * @author terryrao
 */
public class CommonUtils {


    public static InputStream getResource(String fileName) {
        return CommonUtils.class.getClassLoader().getResourceAsStream(fileName);
    }
}
