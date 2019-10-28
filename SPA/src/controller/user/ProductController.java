package controller.user;

import dao.CustomerDao;
import dao.OrdersDao;
import dao.ProductDAO;
import model.*;
import utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductController",urlPatterns = "/product")

public class ProductController extends HttpServlet {
    private OrdersModel orders = new OrdersModel();
    private OrderDetailModel orderDetail = new OrderDetailModel();
    private CustomerModel customer = new CustomerModel();
    private ProductModel product = new ProductModel();
    private ProductDAO productDAO = new ProductDAO();
    private CustomerDao customerDao = new CustomerDao();
    private OrdersDao ordersDao = new OrdersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "view":
                this.getdetailProduct(request,response);
                break;
            case "search":
                this.getSearchProduct(request,response);
                break;
            default:
                this.getListProduct(request,response);
                break;
        }
    }
    protected void getListProduct(HttpServletRequest request, HttpServletResponse response){
        SpaBean spaBeanProduct = new SpaBean();
        SpaBean spaBeanCategorise = new SpaBean();
        try {
            List<ProductModel>products = spaBeanProduct.getAllProduct();
            List<CategoriesModel>categories = spaBeanCategorise.getAllCategories();
            request.setAttribute("products",products);
            request.setAttribute("categories",categories);
            RequestDispatcher requestDispatcherProduct = request.getRequestDispatcher("/views/user/home.jsp");
            requestDispatcherProduct.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void getdetailProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SpaBean spaBeanCategorise = new SpaBean();
        try {
            ProductModel product = new SpaBean().getByIDProduct(id);
            List<CategoriesModel>categories = spaBeanCategorise.getAllCategories();
            request.setAttribute("categories",categories);
            request.setAttribute("product", product);
            RequestDispatcher rq = request.getRequestDispatcher("/views/user/detail.jsp");
            rq.forward(request, response);
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    protected void getSearchProduct(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String search = request.getParameter("keyword");
        int id = Integer.parseInt(request.getParameter("category_id"));
        try {
            List<ProductModel> products = new ProductDAO().getSearch(id,search);
            request.setAttribute("products", products);
            RequestDispatcher rq = request.getRequestDispatcher("/views/user/home.jsp");
            rq.forward(request, response);
        }catch (SQLException e){
            e.getStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


}
