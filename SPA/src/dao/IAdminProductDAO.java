package dao;

import model.ProductModel;

import java.sql.SQLException;
import java.util.List;

public interface IAdminProductDAO {
    void createProduct(ProductModel productModel);

    ProductModel getProductById(int id);

    List<ProductModel> getAllProducts() throws SQLException, ClassNotFoundException;

    void updateProduct(int id, ProductModel productModel);

    void deleteProduct(ProductModel productModel);

    List<ProductModel> getSearchResults(String keyword);
}
