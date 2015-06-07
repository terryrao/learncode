package org.raowei.test.annotations;

import java.lang.annotation.*;

/**
 * Created by terryrao on 6/7/2015.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface ExtractInterface {
    public String value();

}
