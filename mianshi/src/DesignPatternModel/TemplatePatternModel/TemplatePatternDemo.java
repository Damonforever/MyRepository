package DesignPatternModel.TemplatePatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 15:10
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
