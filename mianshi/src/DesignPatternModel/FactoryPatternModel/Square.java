package DesignPatternModel.FactoryPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 14:35
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
