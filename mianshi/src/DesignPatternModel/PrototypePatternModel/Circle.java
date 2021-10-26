package DesignPatternModel.PrototypePatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 15:31
 */
public class Circle extends Shape{
    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
