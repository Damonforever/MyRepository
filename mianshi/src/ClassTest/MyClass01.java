package ClassTest;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/21 17:16
 */
public class MyClass01 {
    protected User user;

    public MyClass01() {
    }

    public MyClass01(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
