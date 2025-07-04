package service;

import model.CartItem;
import model.Product;

import java.util.List;

public class ShippingService {
    public static void ship(List<CartItem> items){
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for(CartItem item : items){
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            System.out.printf("%dx %s %.0fg  \n", quantity, product.getName(), product.getWeight() * 1000 * quantity);
            totalWeight += quantity * product.getWeight();
        }
        System.out.printf("Total package weight %.2fkg\n", totalWeight);
    }
}
