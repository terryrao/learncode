package org.raowei.test.degin.orthogonal;

/**
 * ${DESCRIPTION}
 * create: 2016-07-13 11:27
 *
 * @author admin
 */
public class NamePredicate implements StudentPredicat {
    private String name;

    NamePredicate(String name) {
        this.name = name;
    }

    public boolean test(Student student) {
        return name.equals(student.getName());
    }
}
