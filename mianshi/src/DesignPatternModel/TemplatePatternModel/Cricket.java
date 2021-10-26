package DesignPatternModel.TemplatePatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 15:07
 */
public class Cricket extends Game{
    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
