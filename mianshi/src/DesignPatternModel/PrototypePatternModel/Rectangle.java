package DesignPatternModel.PrototypePatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 15:30
 */
public class Rectangle extends Shape{
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
