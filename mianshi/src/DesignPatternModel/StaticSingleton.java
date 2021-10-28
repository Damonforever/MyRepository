package DesignPatternModel;

/**
 * @description: 安全且高效的单例，既保证安全，又保证了延时加载，利用内部类
 * @author: Damon
 * @date 2021/10/27 11:08
 */
public class StaticSingleton {
    private StaticSingleton(){

    }
    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }
    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
