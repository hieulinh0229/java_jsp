package controller.user;

import dao.ProductDAO;
import model.CategoriesModel;
import model.ProductModel;
import model.SpaBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet",urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String search = request.getParameter("keyword");
        SpaBean spaBeanCategorise = new SpaBean();
        try {
            List<CategoriesModel>categories = spaBeanCategorise.getAllCategories();
            request.setAttribute("categories",categories);
            List<ProductModel> products = new ProductDAO().getSearch(id,search);
            if (products.isEmpty()){
                String noResult = "KHÔNG TÌM THẤY KẾT QUẢ";
                request.setAttribute("noResult",noResult);
            }else {request.setAttribute("products", products);}
            int sumResult = products.size();
            request.setAttribute("sumResult", sumResult);
            RequestDispatcher rq = request.getRequestDispatcher("/views/user/SearchProduct.jsp");
            rq.forward(request, response);
        }catch (SQLException e){
            e.getStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
