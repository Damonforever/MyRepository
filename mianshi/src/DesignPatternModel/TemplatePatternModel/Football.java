package DesignPatternModel.TemplatePatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 15:08
 */
public class Football extends Game{
    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
