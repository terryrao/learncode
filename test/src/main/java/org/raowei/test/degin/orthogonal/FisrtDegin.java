package org.raowei.test.degin.orthogonal;

import java.util.function.Predicate;

/**
 * ${DESCRIPTION}
 * create: 2016-07-13 9:51
 *
 * @author admin
 */
public class FisrtDegin {

    /**
     * 此方法的缺点
     * 1。缺乏弹性参数类型，不能支持List、Set之类的
     * 2。容易出错，操作数组下标，往往引入不经意的错误
     * 3。幻数：将算法与配置高度耦合
     * 4。返回null 再次给用户打开了犯错的大门
     *
     */
    static Student findByAge(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getAge() == 18) {
                return students[i];
            }
        }
        return null;
    }

    /**
     * 最小依赖原则
     */
    static Student findByAge2(Student[] students) {
        for (Student student : students) {
            if (student.getAge() == 18) {
                return student;
            }
        }
        return null;
    }

    /*=================新需求：查找一个名字为horance的学生 ========================= */
    /**
     *
     * 重复设计
     * Copy-Paste是最快的实现方法
     */

    static Student findByName(Student[] students) {
        for (Student student : students) {
            if (student.getName().equals("harance")) {
                return student;
            }
        }
        return  null;
    }

    /**
     * 消除重复，可以将“查找变化”和“比较准则”这两个“变化方向”进行分离
     *
     * 此方法设计仍然有结构性重复
     */

    static Student find(Student[] students,StudentPredicat sp) {
        for (Student student : students) {
            if (sp.test(student)) {
                return student;
            }
        }
        return null;
    }

    /**
     * 消除结构性重复
     * {@link AgePredicate } 和 {@link NamePredicate } 都存在结构性重复，可以使用lambda [code as data]
     * 这样就可以不用定义 AgePredicate 和 NamePredicate 这两个类了，消除了类定义的重复
     */

    static Student find(Student[] students) {
        find(students,s -> s.getAge() == 18);
        return find(students,s-> s.getName().equals("harance"));
    }



    /*===========================================================================*/




     /*=============================向稳定的方向依赖 ==================================*/
    /**
     * 为了适应诸如List, Set等多种数据结构，甚至包括原生的数组类型，可以将入参重构为更加抽象的Iterable类型
     */

    static Student find(Iterable<Student> students, StudentPredicat sp) {
        for (Student student : students) {
            if (sp.test(student)) {
                return student;
            }
        }
        return null;
    }

    /*===========================================================================*/


     /*=============================存在一个老师列表，查找第一个女老师 ==================================*/

    /**
     * 类型重复
     */
    static Teacher find(Iterable<Teacher> teachers, TeacherPredicate p) {
        for (Teacher t : teachers)
            if (p.test(t))
                return t;
        return null;}


    public static Teacher find(Iterable<Teacher> teachers) {
        find(teachers, Teacher::getFemale);
        return find(teachers, s -> s.getGender().equals("女") );
//        return find(students,s-> s.getName().equals("harance"));
    }

    /**
     * 参数化
     * StudentMacher/TeacherPredicate, find(Iterable<Student>)/find(Iterable<Teacher>)的重复，为此引入「类型参数化」的设计
     *
     */


    static <E> E find2(Iterable<? extends E> c, Predicate < ? super E> p) {
        for (E e : c) {
            if (p.test(e)) {
                return e;
            }
        }
        return null;
    }


    /**
     * 复用lambda
     * 如果做到极致，可认为两个lambda表达式也是重复的。
     * 从「分离变化的方向」的角度分析，此lambda表达式承载的「比较算法」与「参数配置」两个职责，应该对其进行分离
     */

    static void assertThat(Iterable<Student> students ) {
//        find(students,s -> s.getName().equals("horance"));
//        find(students,s -> s.getAge() == 18);
    }

    /**
     * 复用lambda
     * 但是，将lambda表达式封装在Factory的设计是及其脆弱的
     *
     */
     static class StudentPredicates{

        public static Predicate<Student> age(int age) {
            return  s -> s.getAge() == age;
        }

        public static Predicate<Student> name(String name) {
            return s -> s.getName().equals(name);
        }

        public static Predicate<Student> ageNe(int age) {
            return s -> s.getAge() != age;
        }

    }

    /**
     *复用lambda
     */
    static  void assertThat2(Iterable<Student> students) {
        find2(students,StudentPredicates.age(18));
        find2(students,StudentPredicates.name("horance"));
    }


    /*===========================================================================*/

     /*=============================查找年龄不等于18岁的女生 ==================================*/

    /**
     * 最简单的方法是在{@link StudentPredicates} 加 {@link StudentPredicates#ageNe}方法
     * 停地增加「Static Factory Method」，但这样的设计严重违反了「OCP」(开放封闭)原则
     * 从需求上看，比较准则增加了众多语义，再次运用“分离变化方向”的原则，可发现存在两类运算的规则:
     * 比较运算：==, !=
     * 逻辑运算：&&, ||
     * 比较语义
     * 先处理比较运算的变化方向，为此建立一个Matcher的抽象
     */

    final static class StudendtPredicates2 {

        public static Predicate<Student> age(Matcher<Integer> studentMatcher) {
            return student -> studentMatcher.matches(student.getAge());
        }


    }

    Student find(Iterable<Student> iterator, Predicate<Student> p) {
        for (Student student : iterator) {
            if (p.test(student)){
                return student;
            }

        }
        return null;
    }

    //查找年龄不等于18岁的学生，可以如此描述
    void test(Iterable<Student> students) {
        find(students,StudendtPredicates2.age(Matcher.ne(18)));
    }




    /*===========================================================================*/


}
