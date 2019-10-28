package controller.admin;

import dao.IAdminProductDAO;
import dao.impl.AdminProductDAOImpl;
import model.ProductModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductsController", urlPatterns = "/admin-products")
public class ProductsController extends HttpServlet {

    private IAdminProductDAO productDAO = new AdminProductDAOImpl ();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct (request, response);
                break;
            case "edit":
                updateProduct (request, response);
                break;
            case "delete":
                deleteProduct (request, response);
                break;
            case "search":
                showSearchResult (request,response);
                break;
            default:
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name_product = request.getParameter ("name_product");
        double original_price = Double.parseDouble (request.getParameter ("original_price"));
        double price = Double.parseDouble (request.getParameter ("price"));
        int amount = Integer.parseInt (request.getParameter ("amount"));
        int category_id = Integer.parseInt (request.getParameter ("category_id"));
        String image = request.getParameter ("response");
        String description = request.getParameter ("description");

        ProductModel productModel = new ProductModel (name_product, original_price, price, amount, category_id, image, description);
        this.productDAO.createProduct (productModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/create.jsp");
        request.setAttribute("message", "Sản phẩm mới đã được tạo thành công");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt (request.getParameter ("id"));
        String name_product = request.getParameter ("name_product");
        double original_price = Double.parseDouble (request.getParameter ("original_price"));
        double price = Double.parseDouble (request.getParameter ("price"));
        int amount = Integer.parseInt (request.getParameter ("amount"));
        int category_id = Integer.parseInt (request.getParameter ("category_id"));
        String image = request.getParameter ("response");
        String description = request.getParameter ("description");

        ProductModel productModel = this.productDAO.getProductById (id);
        RequestDispatcher requestDispatcher;
        productModel.setName_product (name_product);
        productModel.setOriginal_price (original_price);
        productModel.setPrice (price);
        productModel.setAmount (amount);
        productModel.setCategory_id (category_id);
        productModel.setImage (image);
        productModel.setDescription (description);

        this.productDAO.updateProduct (id, productModel);
        request.setAttribute("products", productModel);
        request.setAttribute("message", "Thông tin sản phẩm đã được cập nhật thành công");
        requestDispatcher = request.getRequestDispatcher("/views/admin/product/edit.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductModel deleteProduct = this.productDAO.getProductById (id);
        this.productDAO.deleteProduct (deleteProduct);
        request.setAttribute("message", "Tài khoản đã xoá thành công");
        try {
            response.sendRedirect("/admin-products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSearchResult(HttpServletRequest request, HttpServletResponse response) {
        String keyword = request.getParameter("search");
        List<ProductModel> searchResult = this.productDAO.getSearchResults(keyword);
        request.setAttribute("result", searchResult);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/admin-search.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProducts (request, response);
                break;
            default:
                listProducts (request, response);
                break;
        }
    }

    private void viewProducts(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_product"));
        ProductModel productModel = this.productDAO.getProductById (id);
        request.setAttribute("products", productModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductModel deleteProduct = this.productDAO.getProductById (id);
        RequestDispatcher requestDispatcher;
        request.setAttribute("products", deleteProduct);
        requestDispatcher = request.getRequestDispatcher("/views/admin/product/delete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductModel existingProduct = this.productDAO.getProductById (id);
        RequestDispatcher requestDispatcher;
        request.setAttribute("products", existingProduct);
        requestDispatcher = request.getRequestDispatcher("/views/admin/product/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<ProductModel> products = null;
        try {
            products = this.productDAO.getAllProducts ();
        } catch (SQLException e) {
            e.printStackTrace ( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        }
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
