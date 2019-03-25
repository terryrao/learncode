package org.raowei.test.degin.orthogonal;

/**
 * ${DESCRIPTION}
 * create: 2016-07-13 11:25
 *
 * @author admin
 */
public class AgePredicate implements StudentPredicat {
    private int age;


    public AgePredicate(int age) {
        this.age = age;
    }
    public boolean test(Student student) {
        return this.age == student.getAge();
    }

}


