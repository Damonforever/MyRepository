package InputAndOutput;

import java.io.*;

/**
 * @description: 序列化
 * @author: Damon
 * @date 2021/7/10 16:52
 */
public class SerializableTest01 {
    public static void main(String[] args) {
        //序列化
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("object.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user1 = new User("xuliugen", "123456", "male");
        try {
            oos.writeObject(user1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //反序列化
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("object.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user2 = null;
        try {
            user2 = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(user2.getUserName()+ " " +
                user2.getPassword() + " " + user2.getSex());
        //反序列化的输出结果为：xuliugen 123456 male
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\object.out"));
//            oos.writeObject(new User("xuliugen", "123456", "male"));
//            ObjectInputStream ois= new ObjectInputStream(new FileInputStream("D:\\object.out"));
//            try {
//                User user = (User) ois.readObject();
//                System.out.println(user.toString());
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
