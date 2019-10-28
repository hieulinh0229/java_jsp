package dao;

import model.CategoriesModel;
import model.ProductModel;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductDAO {
    public List<ProductModel> getListProduct() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM product ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rss = statement.executeQuery();
        List<ProductModel> products = new LinkedList<ProductModel>();
        while (rss.next()) {
            products.add(new ProductModel(rss.getInt("id_product"),
                    rss.getString("name_product"), rss.getDouble("original_price"),
                    rss.getDouble("price"), rss.getInt("amount"),
                    rss.getInt("category_id"), rss.getString("image"),
                    rss.getString("description")));
        }
        return products;
    }

    public ProductModel getProductById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM `product` WHERE id_product = " + id);
        ResultSet rss = statement.executeQuery();
        ProductModel product = null;
        while (rss.next()) {
            int id_product   =  rss.getInt("id_product");
            String  name_product   =  rss.getString("name_product");
            Double original_price   =  rss.getDouble("original_price");
            Double  price     =  rss.getDouble("price");
            int amount =   rss.getInt("amount");
            int   category_id =  rss.getInt("category_id");
            String  image =  rss.getString("image");
            String description = rss.getString("description");
             product = new ProductModel(id_product, name_product,original_price,
            price,amount,category_id,image,
                    description);
        }
        return product;
    }
    public List<CategoriesModel> getALLCategories() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM categories");
        ResultSet rss = statement.executeQuery();
        List<CategoriesModel> categories = new LinkedList<CategoriesModel>();
        while (rss.next()) {
            categories.add(new CategoriesModel(rss.getInt("id_categories"),
                    rss.getString("name_categories")));
        }
        return categories;
    }
    public List<ProductModel> getSearch(int id ,String search) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM `product` WHERE name_product LIKE '"+search+"%' AND category_id = "+id ;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rss = statement.executeQuery();

            List<ProductModel>product = new ArrayList<> ();
        while (rss.next()) {
            product.add(new ProductModel(rss.getInt("id_product"),
                    rss.getString("name_product"), rss.getDouble("original_price"),
                    rss.getDouble("price"), rss.getInt("amount"),
                    rss.getInt("category_id"), rss.getString("image"),
                    rss.getString("description")));
        }
        return product;
    }
}
