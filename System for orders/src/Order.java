import java.util.Arrays;
import java.util.List;

public class Order {
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public void addProducts(Product... products){
        this.products.addAll(Arrays.asList(products));
    }

    public double calculateTotal(){
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public String toString(){
        return "Order with products: " + products + "Total: " + calculateTotal();
    }
}
