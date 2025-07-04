package service;

import model.Cart;
import model.CartItem;
import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) throws Exception {
        if(cart.isEmpty()) throw new Exception("Cart is Empty!");

        double subtotal = 0.0;
        List<CartItem> shippableItems = new ArrayList<>();
        for(CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if(product.getQuantity() < quantity) throw new Exception(product.getName() + " is out of stock!");
            if(product.isMayExpire() && product.isExpired()) throw new Exception(product.getName() + " is expired!");

            subtotal += (quantity * product.getPrice());

            if(product.isShippable())shippableItems.add(item);
        }

        double totalPrice = subtotal;
        double shippingFee = 30;
        if(!shippableItems.isEmpty()){
            totalPrice += shippingFee;
        }

        if(customer.getBalance() < totalPrice){
            throw new Exception("Insufficient balance!");
        }

        customer.reduceBalance(totalPrice);

        if(!shippableItems.isEmpty()){
            ShippingService.ship(shippableItems);
        }

        for(CartItem item : cart.getItems()){
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println();
        System.out.println("** Checkout receipt **");
        for(CartItem item : cart.getItems()){
            System.out.printf("%dx %s %.2f \n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("-------------------------------------");
        System.out.printf("Subtotal %.2f\n", subtotal);
        System.out.printf("Shipping %.2f\n", shippingFee);
        System.out.printf("Amount %.2f\n", totalPrice);
        System.out.printf("Remaining Balance %.2f\n", customer.getBalance());

        cart.clear();

    }
}
