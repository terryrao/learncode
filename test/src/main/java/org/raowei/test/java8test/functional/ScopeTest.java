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

package org.raowei.test.java8test.functional;

/**
 * @author terryrao
 * @version 1.0 6/14/2015 4:38 PM
 */
public class ScopeTest {

    public static void main(String[] args) {
        ScopeTest test = new ScopeTest();
        test.getAnonymousPrinter().print("anonymousPrinter()");
        test.getLambdaPrinter().print("lambdaPrinter");
    }

    public Printer getLambdaPrinter() {
        System.out.println("ScopeTest.getLambdaPrinter : " + this.getClass());
        Printer printer = (msg)->{
            System.out.println(msg + ": " + this.getClass());
        };
        return printer;
    }

    public Printer getAnonymousPrinter() {
        System.out.println("ScopeTest.getAnonymousPrinter" + this.getClass());
        Printer printer = new Printer() {
            @Override
            public void print(String msg) {
                System.out.println(msg + " : " + this.getClass());
            }
        };
        return printer;
    }
}
