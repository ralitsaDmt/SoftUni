package BookShop_02;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String name, String author, double price){
        super(name, author, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 1.3;
    }
}
