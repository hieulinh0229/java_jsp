package dao;

import model.OrderDetailModel;
import model.OrdersModel;
import utils.DBConnection;

import java.sql.*;
import java.util.List;

public class OrdersDao {
public boolean createOrder(OrdersModel orders) throws SQLException,ClassNotFoundException{
    Connection connection = DBConnection.getConnection();
    PreparedStatement statement =
    connection.prepareStatement
    ("INSERT INTO orders(order_date,id_employee,id_customer) VALUE (?,?,?)");
    statement.setString(1,orders.getOrder_date());
    statement.setInt(2,orders.getId_employee());
    statement.setInt(3,orders.getId_customer());
    boolean rowUpdate = statement.executeUpdate()>0;
    statement.close();
    return  rowUpdate;
}
public int getIdHoaDon() throws SQLException, ClassNotFoundException{
    String sql = "SELECT  * FROM ORDERS ORDER BY id_orders DESC LIMIT 1 ";
    Connection connection =DBConnection.getConnection();
    PreparedStatement statement  = connection.prepareStatement(sql);
    ResultSet resultSet = statement.executeQuery();
    int id =0;
    while (resultSet.next()){
        id= resultSet.getInt("id_orders");
    }statement.close();
    resultSet.close();
    return id;
}
    public boolean createDetailOrder(OrderDetailModel orders) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement =
                connection.prepareStatement
                        ("INSERT INTO ordersdetails(id_orders,id_product,amount,price,total_money,name_customer,phone,address) VALUE (?,?,?,?,?,?,?,?)");
        statement.setInt(1,orders.getId_orders());
        statement.setInt(2,orders.getId_product());
        statement.setInt(3,orders.getAmount());
        statement.setFloat(4,orders.getPrice());
        statement.setFloat(5,orders.getTotal_money());
        statement.setString(6,orders.getName_customer());
        statement.setInt(7,orders.getPhone());
        statement.setString(8,orders.getAddress());
        boolean rowUpdate = statement.executeUpdate()>0;
        statement.close();
        return  rowUpdate;
    }
}
