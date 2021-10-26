package DesignPatternModel.ProxyPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 16:25
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}
