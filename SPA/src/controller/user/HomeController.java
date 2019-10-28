package controller.user;

import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {
    private IUserDAO userDAOImpl = new UserDAOImpl ();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter ("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                login (request,response);
                break;
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        UserModel userModel = new UserModel ();
        userModel.setUserName (userName);
        userModel.setPassword (password);

        try {
            String userValidate = userDAOImpl.authenticateUser(userModel);
            if (userValidate.equals("admin")) {
                session.setAttribute ("username",userName);
                dispatcher = request.getRequestDispatcher("/views/admin/home.jsp");
                response.sendRedirect("/admin-home");
            } else if (userValidate == "user") {
                session.setAttribute ("username",userName);
                dispatcher = request.getRequestDispatcher("/views/user/home.jsp");
                response.sendRedirect("/product");
            } else {
                request.setAttribute("message", userValidate);
                dispatcher = request.getRequestDispatcher("/views/admin/login.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);

        if (session != null) {
           HttpSession httpSession = request.getSession ();
           httpSession.removeAttribute ("username");
            response.sendRedirect("/product");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter ("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                viewLogin (request,response);
                break;
            case "logout":
                logout (request,response);
                break;
            default:
                viewIndex (request,response);
                break;
        }

    }
    private void viewLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/login.jsp");
        rd.forward(request, response);
    }
    private void viewIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher ("/views/user/home.jsp");
        rd.forward (request, response);
    }
}
