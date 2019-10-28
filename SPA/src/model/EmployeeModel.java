package model;

public class EmployeeModel {
    private int id_employee =1001;
    private String name;
    private int sex_employee;
    private int phone;

    public EmployeeModel() {
    }

    public EmployeeModel(int id_employee, String name, int sex_employee, int phone) {
        this.id_employee = id_employee;
        this.name = name;
        this.sex_employee = sex_employee;
        this.phone = phone;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex_employee() {
        return sex_employee;
    }

    public void setSex_employee(int sex_employee) {
        this.sex_employee = sex_employee;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
