package DesignPatternModel.AbstractFactoryPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 14:48
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
