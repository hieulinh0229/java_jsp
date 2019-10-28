package model;

import java.sql.Date;
import java.util.List;
import java.util.Random;

public class OrdersModel {

    private int id_order;
    protected String order_date;
    private int id_employee = 2256;
    private int id_customer;
    private List<IteamModel> iteam;
    private int status;
    private UserModel user;

    public OrdersModel(String order_date, int id_employee, int id_customer) {
        this.order_date = order_date;
        this.id_employee = id_employee;
        this.id_customer = id_customer;
    }
    public OrdersModel(){
        this.status =0;
    }
    public OrdersModel(int id_order, int id_employee, int id_customer, String order_date) {
        this.id_order = id_order;
        this.id_employee = id_employee;
        this.id_customer = id_customer;
        this.order_date = order_date;
    }
    public List<IteamModel> getIteam() {
        return iteam;
    }
    public void setIteam(List<IteamModel> iteam) {
        this.iteam = iteam;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getId_order() {
        return id_order;
    }

    public int getId_employee() {
        return id_employee;
    }

    public int getId_customer() {
        return id_customer;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}
