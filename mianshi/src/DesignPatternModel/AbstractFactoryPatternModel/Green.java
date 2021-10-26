package DesignPatternModel.AbstractFactoryPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 14:47
 */
public class Green implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
