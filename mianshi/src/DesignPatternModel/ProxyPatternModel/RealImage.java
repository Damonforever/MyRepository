package DesignPatternModel.ProxyPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 16:22
 */
public class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
