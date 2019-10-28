package controller.admin;

import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UsersController", urlPatterns = "/admin-users")
public class UsersController extends HttpServlet {

    private IUserDAO userDAO = new UserDAOImpl ();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "register":
                registerUser(request, response);
                break;
            case "edit":
                updateUser(request, response);
                break;
            case "delete":
                deleteUser(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserModel deleteUser = this.userDAO.getUserById (id);
        this.userDAO.deleteUser (deleteUser);
        request.setAttribute("message", "Tài khoản đã xoá thành công");
        try {
            response.sendRedirect("/admin-users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        int status = Integer.parseInt (request.getParameter ("status"));
        int roleid = Integer.parseInt (request.getParameter ("roleid"));

        UserModel userModel = this.userDAO.getUserById (id);
        RequestDispatcher requestDispatcher;
        userModel.setUserName (username);
        userModel.setPassword (password);
        userModel.setFullName (fullname);
        userModel.setStatus (status);
        userModel.setRoleId (roleid);

        this.userDAO.updateUser (id, userModel);
        request.setAttribute("users", userModel);
        request.setAttribute("message", "Thông tin tài khoản đã được cập nhật thành công");
        requestDispatcher = request.getRequestDispatcher("/views/admin/user/edit.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        int status = Integer.parseInt (request.getParameter ("status"));
        int roleid = Integer.parseInt (request.getParameter ("roleid"));

        UserModel userModel = new UserModel (username, password, fullname, status, roleid);
        this.userDAO.createUser (userModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/user/create.jsp");
        request.setAttribute("message", "Tài khoản mới đã được tạo thành công");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");


        UserModel userModel = new UserModel (username, password, fullname);
        this.userDAO.registerUser (userModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/register.jsp");
        request.setAttribute("message", "Tài khoản đã được tạo thành công");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
            case "register":
                showRegisterForm (request,response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewUsers (request, response);
                break;
            default:
                listUsers (request, response);
                break;
        }
    }

    private void viewUsers(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserModel userModel = this.userDAO.getUserById (id);
        request.setAttribute("users", userModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/user/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/register.jsp");
        try {
            rd.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace ( );
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        UserModel deleteUser = this.userDAO.getUserById (id);
        RequestDispatcher requestDispatcher;
        request.setAttribute("users", deleteUser);
        requestDispatcher = request.getRequestDispatcher("/views/admin/user/delete.jsp");
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
        UserModel existingUser = this.userDAO.getUserById (id);
        RequestDispatcher requestDispatcher;
        request.setAttribute("users", existingUser);
        requestDispatcher = request.getRequestDispatcher("/views/admin/user/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/user/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) {
        List<UserModel> users = null;
        try {
            users = this.userDAO.getAllUsers ();
        } catch (SQLException e) {
            e.printStackTrace ( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace ( );
        }
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/user/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
