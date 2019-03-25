package org.raowei.test.java8test.lamda.repeatAnnotation;

/**
 * Created by terryrao on 5/15/2015.
 */
public class RepeatAnnotationUseOldVersion {
    @Authorities({@Authority(role = "admin"),@Authority(role = "Manager")})
    public void doSomeThing() {

    }

    /**
     * 重复注解
     */
    @Authority2(role = "admin")
    @Authority2(role = "manager")
    public void dosomethingmore() {

    }
}
