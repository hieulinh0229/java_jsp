package dao.impl;

import dao.IAdminProductDAO;
import model.ProductModel;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminProductDAOImpl implements IAdminProductDAO {
    Connection connection = DBConnection.getConnection ( );
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    String sql = null;
    ResultSet resultSet;

    @Override
    public void createProduct(ProductModel productModel) {
        sql = "insert into product(name_product, original_price, price, amount, category_id, image, description) values(?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setString (1, productModel.getName_product ( ));
            preparedStatement.setDouble (2, productModel.getOriginal_price ( ));
            preparedStatement.setDouble (3, productModel.getPrice ( ));
            preparedStatement.setInt (4, productModel.getAmount ( ));
            preparedStatement.setInt (5, productModel.getCategory_id ( ));
            preparedStatement.setString (6, productModel.getImage ( ));
            preparedStatement.setString (7, productModel.getDescription ( ));

            preparedStatement.execute ( );
            preparedStatement.close ( );
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
    }

    @Override
    public ProductModel getProductById(int id) {
        ProductModel productModel = null;
        sql = "select * from product where id_product = ?";
        try {
            preparedStatement = connection.prepareStatement (sql);
            preparedStatement.setInt (1, id);

            resultSet = preparedStatement.executeQuery ( );
            if (resultSet.next ( )) {
                String name_product = resultSet.getString ("name_product");
                double original_price = resultSet.getDouble ("original_price");
                double price = resultSet.getDouble ("price");
                int amount = resultSet.getInt ("amount");
                int category_id = resultSet.getInt ("category_id");
                String image = resultSet.getString ("image");
                String description = resultSet.getString ("description");

                productModel = new ProductModel (id, name_product, original_price, price, amount, category_id, image, description);

                resultSet.close ( );
                preparedStatement.close ( );
            }
        } catch (SQLException e) {
            e.printStackTrace ( );
        }
        return productModel;
    }

    @Override
    public List<ProductModel> getAllProducts() throws SQLException, ClassNotFoundException {
        List<ProductModel> listProducts = new ArrayList<> ();
        sql = "select * from product";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt ("id_product");
                String name_product = resultSet.getString ("name_product");
                double original_price = resultSet.getDouble ("original_price");
                double price = resultSet.getDouble ("price");
                int amount = resultSet.getInt ("amount");
                int category_id = resultSet.getInt ("category_id");
                String image = resultSet.getString ("image");
                String description = resultSet.getString ("description");

                ProductModel productModel = new ProductModel (id, name_product, original_price, price, amount, category_id, image, description);
                listProducts.add(productModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProducts;
    }

    @Override
    public void updateProduct(int id, ProductModel productModel) {
        sql = "update product set name_product = ?, original_price = ?, price = ?, amount = ?, category_id = ?, image = ?, description = ? where id_product = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString (1, productModel.getName_product ( ));
            preparedStatement.setDouble (2, productModel.getOriginal_price ( ));
            preparedStatement.setDouble (3, productModel.getPrice ( ));
            preparedStatement.setInt (4, productModel.getAmount ( ));
            preparedStatement.setInt (5, productModel.getCategory_id ( ));
            preparedStatement.setString (6, productModel.getImage ( ));
            preparedStatement.setString (7, productModel.getDescription ( ));
            preparedStatement.setInt(8, productModel.getId_product());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(ProductModel productModel) {
        sql = "delete from product where id_product = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productModel.getId_product());

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductModel> getSearchResults(String keyword) {
        List<ProductModel> searchResult = new ArrayList<>();
        sql = "select id_product, name_product, original_price, price, amount, category_id, image, description from product where name_product  like '%" + keyword + "%';";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt ("id_product");
                String name_product = resultSet.getString ("name_product");
                double original_price = resultSet.getDouble ("original_price");
                double price = resultSet.getDouble ("price");
                int amount = resultSet.getInt ("amount");
                int category_id = resultSet.getInt ("category_id");
                String image = resultSet.getString ("image");
                String description = resultSet.getString ("description");

                ProductModel productModel = new ProductModel (id, name_product, original_price, price, amount, category_id, image, description);

                searchResult.add(productModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchResult;
    }
}
