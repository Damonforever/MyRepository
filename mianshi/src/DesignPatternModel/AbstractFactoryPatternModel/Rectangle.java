package DesignPatternModel.AbstractFactoryPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 14:35
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
