package dao;

import model.EmployeeModel;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDao {
    public List<EmployeeModel> getListEmploye() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM employee";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rss = statement.executeQuery();
        List<EmployeeModel> employee = new LinkedList<EmployeeModel>();
        while (rss.next()) {
            employee.add(new EmployeeModel(rss.getInt("id_employee"),
                    rss.getString("name"), rss.getInt("sex_employee"),
                    rss.getInt("phone")));
        }
        return employee;
    }
}
