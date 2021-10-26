package DesignPatternModel.AbstractFactoryPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 14:46
 */
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
