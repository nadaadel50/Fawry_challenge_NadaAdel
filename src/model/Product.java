package model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    private boolean mayExpire;
    private Date expireDate;
    private boolean shippable;
    private double weight;

    public Product(int id, String name, double price, int quantity, boolean mayExpire, Date expireDate, boolean shippable, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.mayExpire = mayExpire;
        this.expireDate = expireDate;
        this.shippable = shippable;
        this.weight = weight;
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public double getPrice() {return price;}
    public int getQuantity() {return quantity;}
    public boolean isMayExpire() {return mayExpire;}
    public Date getExpireDate() {return expireDate;}
    public boolean isShippable() {return shippable;}
    public double getWeight() {return weight;}

    public boolean isExpired(){
        return isMayExpire() && new Date().after(expireDate);
    }

    public void reduceQuantity(int amount) {quantity -= amount;}
}
