package DesignPatternModel.AbstractFactoryPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 14:36
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
