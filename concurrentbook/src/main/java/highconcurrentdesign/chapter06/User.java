package highconcurrentdesign.chapter06;

/**
 * @author raowei
 * @date 2019-03-27
 */
public class User {

    private int id;
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User(int id) {
        this.id = id;
    }

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
