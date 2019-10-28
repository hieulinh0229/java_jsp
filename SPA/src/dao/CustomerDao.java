package dao;

import model.CustomerModel;
import utils.DBConnection;

import java.sql.*;

public class CustomerDao {
    public boolean createkhachhang(CustomerModel customer) throws SQLException,ClassNotFoundException {
        String sql = "INSERT INTO customer (name_customer,phone,address) VALUES (?,?,?)";

        //L?y chu?i k?t n?i t?i CSDL truy?n vào bi?n conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement.setString(1, customer.getName_customer());
        statement.setInt(2, customer.getPhone());
        statement.setString(3, customer.getAddress());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();

        // region Gi?i phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowInserted;
    }

    public int getidkhachhang() throws SQLException {
        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        //Tạo đường dẫn kết nối tới CSDL
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT id_customer,name_customer,phone FROM customer ORDER BY id_customer DESC LIMIT 1";

        ResultSet resultSet = statement.executeQuery(sql);
        int id = 0;
        if (resultSet.next()) {

            id = resultSet.getInt("id_customer");
        }
        resultSet.close();
        statement.close();

        return id;
    }
}
