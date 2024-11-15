public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Product: " + name + "price: " + price + "quantity: " + quantity;
    }

    public double getPrice() {
        return (double) price;
    }

    public int getQuantity() {
        return (int) quantity;
    }
}
