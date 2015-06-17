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

package org.raowei.test.innerclass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author terryrao
 * @version 1.0 6/14/2015 9:18 AM
 */
public class CallBackTest {
    private List<CallBack> callBacks = new ArrayList<>();

    public void add(CallBack callBack) {
        callBacks.add(callBack);
    }

    public CallBack generatorCallBack(int no) {
//        return new CallBack(){
//            @Override
//            public void call() {
//                System.out.println("callBack : " + no);
//            }
//        };
        return () -> System.out.println("callBack : " + no);
    }

    public void callBackAll() {
        for (int i = 0; i < callBacks.size(); i++) {
            CallBack callBack =  callBacks.get(i);
            callBack.call();
        }
    }

    public static void main(String[] args) {
        CallBackTest test = new CallBackTest();
        test.add(test.generatorCallBack(1));
        test.add(test.generatorCallBack(2));
        test.add(test.generatorCallBack(3));
        System.out.println("==============开始调用 ============");
        test.callBackAll();
    }


}
