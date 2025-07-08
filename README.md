📦 E-commerce System — Internship Challenge

✅ Project Overview

This project is a simple object-oriented e-commerce system developed for the Fawry Full Stack Development Internship Challenge.
It demonstrates core OOP principles in Java by simulating an online store with realistic product handling, cart operations, checkout logic, and shipping management — all designed to be extensible and testable for future upgrades like a real database or web layer.

Define products (with perishable, shippable, and weight properties)

Add products to a cart

Perform checkout with subtotal, shipping calculation, and balance checks

Send shippable items to a mock ShippingService interface

🛒 Key Features
Product Management

Each product has: id, name, price, quantity, perishable flag, expiryDate (if perishable), shippable flag, and weight (if shippable).

Cart

Customers can add products to the cart with a specific quantity, limited by available stock.

Checkout

Calculates:

Subtotal

Shipping fees for shippable items

Paid amount (subtotal + shipping)

Customer balance after payment

Validates:

Insufficient stock

Expired perishable products

Empty cart

Insufficient balance

Shipping Service

Collects all shippable items implementing a Shippable interface and prints shipping details.


🧩 Corner Cases Handled
✔️ Error if a product is out of stock.
✔️ Error if a product has expired.
✔️ Error if the cart is empty.
✔️ Error if the customer’s balance is insufficient.
✔️ Automatically updates product stock after successful checkout.

🗃️ Folder Structure

/src
 ├── model/
 │   ├── Product.java         # Defines product properties and expiry logic
 │   ├── Cart.java            # Holds items customer wants to buy
 │   ├── CartItem.java        # Links Product + quantity in cart
 │   ├── Customer.java        # Holds customer balance and name
 ├── service/
 │   ├── CheckoutService.java # Handles all validation, payment, shipping
 │   ├── ShippingService.java # Handles shipping logic (prints shipment notice)
 ├── Main.java                # Demo scenario with sample products and checkout


📄 Example Scenario
In Main.java:
![image](https://github.com/user-attachments/assets/89eed8db-7cf2-42b3-9175-578bb0528646)

Output:
![image](https://github.com/user-attachments/assets/eb4eccf0-533b-4df2-a17c-dabb4b28ccb6)
