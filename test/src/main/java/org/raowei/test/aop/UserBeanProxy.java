/*
 * Copyright (c) 2015. [${USER}]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.raowei.test.aop;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author terryrao
 * @version 1.0 6/9/2015 10:25 PM
 */
public class UserBeanProxy implements InvocationHandler {
    private Object target;

    public UserBeanProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        UserBeanImpl userBean = (UserBeanImpl)this.target;
        String userName = userBean.getUserName();
        Object result = null;
        if (userName != null && !userName.equals("")) {
            System.out.println("args " + args);
            System.out.println("========");
            result = method.invoke(target,args);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("proxystart -----");
        UserBeanImpl userBean = new UserBeanImpl("json crazy");
        UserBean proxy = (UserBean) Proxy.newProxyInstance(userBean.getClass().getClassLoader(), userBean.getClass().getInterfaces(),new UserBeanProxy(userBean));
        proxy.updateUser("nikd");
        System.out.println("proxy end ----");

        UserBean object  = new UserBeanImpl();
        UserBean boject = (UserBean) Proxy.newProxyInstance(userBean.getClass().getClassLoader(),userBean.getClass().getInterfaces(),new UserBeanProxy(object));
        boject.addUser();


    }
}
