package DesignPatternModel.ProxyPatternModel;

/**
 * @description:
 * @author: Damon
 * @date 2021/10/3 16:24
 */
public class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
