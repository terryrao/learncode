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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author terryrao
 * @version 1.0 6/14/2015 1:00 PM
 */
public class Persion {
    private String firstName;
    private String LastName;
    private LocalDate dob;
    private Gender gender;

    public Persion() {
    }

    public Persion(String firstName, String lastName, LocalDate dob, Gender gender) {
        this.firstName = firstName;
        LastName = lastName;
        this.dob = dob;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", dob=" + dob +
                '}';
    }

    public static List<Persion> getPersions() {
        List<Persion> persions = new ArrayList<>();
        persions.add(new Persion("Jhon","Jacobs",LocalDate.of(1975,1,20), Gender.MALE));
        persions.add(new Persion("Wally","Inman",LocalDate.of(1965,9,27), Gender.MALE));
        persions.add(new Persion("Donna","Jacobs",LocalDate.of(1970,9,12), Gender.FEMALE));

        return persions;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
