package model;

public class OrderDetailModel {
    private int id_orders;

    public String getName_customer() {
        return name_customer;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderDetailModel(int id_orders, int id_product, int amount, float price, float total_money, String name_customer, int phone, String address) {
        this.id_orders = id_orders;
        this.id_product = id_product;
        this.amount = amount;
        this.price = price;
        this.total_money = total_money;
        this.name_customer = name_customer;
        this.phone = phone;
        this.address = address;
    }

    private int id_product;
    private int amount;
    private float price;
    private float total_money;
    private String name_customer;
    private  int phone;
    private  String address;
    public OrderDetailModel(){}
    public OrderDetailModel(int id_orders, int id_product, int amount, float price, float total_money) {
        this.id_orders = id_orders;
        this.id_product = id_product;
        this.amount = amount;
        this.price = price;
        this.total_money = total_money;
    }

    public int getId_orders() {
        return id_orders;
    }

    public void setId_orders(int id_orders) {
        this.id_orders = id_orders;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }
}
