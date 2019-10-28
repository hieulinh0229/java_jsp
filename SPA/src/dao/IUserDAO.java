package dao;

import model.UserModel;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

    void createUser(UserModel userModel);

    void registerUser(UserModel userModel);

    UserModel getUserById(int id);

    List<UserModel> getAllUsers() throws SQLException, ClassNotFoundException;

    void updateUser(int id, UserModel userModel);

    void deleteUser(UserModel userModel);

    String authenticateUser(UserModel userModel) throws NoSuchAlgorithmException;

    boolean checkUsername(String username);
    UserModel getUserByUsername(String username);
}
