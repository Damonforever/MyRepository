package DesignPatternModel.PrototypePatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 15:31
 */
public class Square extends Shape{
    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
