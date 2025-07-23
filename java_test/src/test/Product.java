package test;

public class Product {
    private int pid;
    private String title;
    private double price;

    public Product(int pid, String title, double price) {
        this.pid = pid;
        this.title = title;
        this.price = price;
    }

    // public double getPrice(double price) {
    // return this.price = 50000;
    // }

    public String getTitle() {
        return title;
    }
    // getTitle이 있으니 무조건 getTitle이 필요함
    // return을 하는데 title만 적으면 됨...
    // getter를 써야되는 이유는 setter는 getter가 있어야함...getter는 혼자 있어도
    // 상관없음

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", title=" + title + ", price=" + price + "]";
    }

    public Object getTitle(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitle'");
    }
}
