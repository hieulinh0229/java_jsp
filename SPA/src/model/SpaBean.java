package model;

import dao.OrdersDao;
import dao.ProductDAO;
import utils.DBConnection;

import java.sql.SQLException;
import java.util.List;

public class SpaBean {
    public List<ProductModel> getAllProduct()throws SQLException,ClassNotFoundException{
        return new ProductDAO().getListProduct();
    }
    public ProductModel getByIDProduct(int id)throws SQLException,ClassNotFoundException{
        return new ProductDAO().getProductById(id);
    }
    public List<CategoriesModel> getAllCategories()throws SQLException,ClassNotFoundException{
        return new ProductDAO().getALLCategories();
    }
}
