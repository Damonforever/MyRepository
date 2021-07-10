package InputAndOutput;

import java.io.Serializable;

/**
 * @description:
 * @author: Damon
 * @date 2021/7/10 16:53
 */
public class User implements Serializable {
    private String userName;
    private String password;
    private String sex;

    public User() {
    }

    public User(String userName, String password, String sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
