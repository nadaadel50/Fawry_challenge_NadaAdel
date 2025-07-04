import model.Cart;
import model.Customer;
import model.Product;
import service.CheckoutService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            List<Product> products = new ArrayList<Product>();
            products.add(new Product(1, "Cheese", 100, 5, true, addDays(new Date(), 3),true, 0.2));
            products.add(new Product(2, "Biscuits", 150, 2, true, addDays(new Date(), 2),true, 0.7));
            products.add(new Product(3, "TV", 5000, 3, false, null,true, 10));
            products.add(new Product(4, "Mobile", 10000, 15, false, null,true, 0.1));
            products.add(new Product(5, "Scratch Card", 50, 10, false, null,false, 0));

            Customer customer = new Customer("Nada", 8000);
            Cart cart = new Cart();
            cart.add(products.get(0), 5);
            cart.add(products.get(1), 2);
            cart.add(products.get(2), 1);
            cart.add(products.get(4), 10);

            CheckoutService.checkout(customer, cart);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}