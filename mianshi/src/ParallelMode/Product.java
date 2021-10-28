package ParallelMode;

/**
 * @description: 不变模式
 * @author: Damon
 * @date 2021/10/27 11:17
 */
public final class Product {
    private final String no;
    private final String name;
    private final double price;
    public Product(String no, String name, double price){
        super();
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
