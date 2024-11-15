import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        for (String arg : args) {
            String[] productDetails = arg.split(",");
            String name = productDetails[0];
            double price = Double.parseDouble(productDetails[1]);
            int quantity = Integer.parseInt(productDetails[2]);
            Product product = new Product(name, price, quantity);
            productList.add(product);
        }

        Order order = new Order(productList);
        System.out.println(order);
        System.out.printf("Total: %.2f\n", order.calculateTotal());
    }
}