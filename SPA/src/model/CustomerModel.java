package model;

public class CustomerModel {
    private int id_customer;
    private String name_customer;
    private int phone;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerModel(){}
    public CustomerModel( String name_customer, int phone,String address) {
        this.name_customer = name_customer;
        this.phone = phone;
        this.address = address;
    }
    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

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
}
