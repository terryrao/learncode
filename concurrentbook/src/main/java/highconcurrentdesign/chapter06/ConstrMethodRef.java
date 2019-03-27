package highconcurrentdesign.chapter06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class ConstrMethodRef {

    @FunctionalInterface
    interface UserFactory<U extends User> {
        U ceateUser(int id, String name);
    }

    static UserFactory<User> uf = User::new;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i < 10;
             i++) {
            users.add(uf.ceateUser(i, "billy" + Integer.toString(i)));
        }
        users.stream().map(User::getName).forEach(System.out::println);
    }

}
