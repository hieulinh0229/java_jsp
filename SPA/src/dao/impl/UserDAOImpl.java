package dao.impl;

import dao.IUserDAO;
import model.UserModel;
import utils.DBConnection;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {

    Connection connection = DBConnection.getConnection();
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    String sql = null;
    ResultSet resultSet;

    @Override
    public void createUser(UserModel userModel) {
        sql = "insert into user(username, password, fullname, status, roleid) values(?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userModel.getUserName ());
            preparedStatement.setString(2, userModel.getPassword ());
            preparedStatement.setString(3, userModel.getFullName ());
            preparedStatement.setInt (4, userModel.getStatus ());
            preparedStatement.setInt (5, userModel.getRoleId ());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerUser(UserModel userModel) {
        sql = "insert into user(username, password, fullname, status, roleid) values(?,?,?,'1','2')";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userModel.getUserName ());
            preparedStatement.setString(2, userModel.getPassword ());
            preparedStatement.setString(3, userModel.getFullName ());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public UserModel getUserById(int id) {
        UserModel userModel = null;
        sql = "select * from user where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString ("username");
                String password = resultSet.getString ("password");
                String fullname = resultSet.getString ("fullname");
                int status = resultSet.getInt ("status");
                int roleid = resultSet.getInt ("roleid");

                userModel = new UserModel (id,username, password, fullname, status, roleid);

                resultSet.close();
                preparedStatement.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return userModel;
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> listUsers = new ArrayList<>();
        sql = "select * from user";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt ("id");
                String username = resultSet.getString ("username");
                String password = resultSet.getString ("password");
                String fullname = resultSet.getString ("fullname");
                int status = resultSet.getInt ("status");
                int roleid = resultSet.getInt ("roleid");

                UserModel userModel = new UserModel (id,username, password, fullname, status, roleid);
                listUsers.add(userModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }

    @Override
    public void updateUser(int id, UserModel userModel) {
        sql = "update user set username = ?, password= ?, fullname =?, status=?, roleid = ? where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userModel.getUserName ());
            preparedStatement.setString(2, userModel.getPassword ());
            preparedStatement.setString(3, userModel.getFullName ());
            preparedStatement.setInt(4, userModel.getStatus ());
            preparedStatement.setInt(5, userModel.getRoleId ());
            preparedStatement.setInt(6, userModel.getId());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(UserModel userModel) {
        sql = "delete from user where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userModel.getId ());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String authenticateUser(UserModel userModel) throws NoSuchAlgorithmException {
        statement = null;
        String username = userModel.getUserName ();
        String password = userModel.getPassword ();
        String userNameDB;
        String passwordDB;
        String roleDB;
        String sql = "select username, password, roleid from user";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("roleid");
                if (username.equals(userNameDB) && password.equals(passwordDB)) {
                    if (roleDB.equals("1")) {
                        return "admin";
                    } else {
                        return "user";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Username hoăc password không hợp lệ";
    }

    @Override
    public boolean checkUsername(String username) {
        sql = "select * from user where username = '" + username + "'";
        boolean check = true;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                if (id > 0) {
                    check = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;

    }

    @Override
    public UserModel getUserByUsername(String username) {
        sql = "select id, username, password from user " +
                " where username = '" + username + "'";
        UserModel userModel = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
//                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                userModel = new UserModel (id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userModel;
    }
}
