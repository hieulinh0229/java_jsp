package controller.user;

import dao.CustomerDao;
import dao.OrdersDao;
import dao.ProductDAO;
import model.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "pay":
                this.createCustomer(request,response);
                this.createOrder(request,response);
                this.payOrder(request,response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addInCart":
                this.addInCart(request, response);
                break;
            case "removeProductInCart":
                this.removeProductInCart(request, response);
                break;
            default:

                break;
        }
    }

    protected void addInCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = 1;
        int id;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
            try {
                ProductModel product = new SpaBean().getByIDProduct(id);
                List<CategoriesModel> categories = new SpaBean().getAllCategories();
                request.setAttribute("categories", categories);
                if (product != null) {
                    if (request.getParameter("quantity") != null) {
                        quantity = Integer.parseInt(request.getParameter("quantity"));
                    }
                    HttpSession session = request.getSession();
                    if (session.getAttribute("order") == null) {
                        OrdersModel order = new OrdersModel();
                        List<IteamModel> listIteam = new ArrayList<IteamModel>();
                        IteamModel iteam = new IteamModel();
                        iteam.setQuantity(quantity);
                        iteam.setProduct(product);
                        iteam.setPrice(product.getPrice());
                        listIteam.add(iteam);
                        order.setIteam(listIteam);
                        session.setAttribute("order", order);
                    } else {
                        OrdersModel order = (OrdersModel) session.getAttribute("order");
                        List<IteamModel> listIteam = order.getIteam();

                        boolean check = false;
                        for (IteamModel iteam : listIteam) {
                            if (iteam.getProduct().getId_product() == product.getId_product()) {
                                iteam.setQuantity(iteam.getQuantity() + quantity);
                                check = true;
                            }
                        }
                        if (check == false) {
                            IteamModel iteam = new IteamModel();
                            iteam.setQuantity(quantity);
                            iteam.setProduct(product);
                            iteam.setPrice(product.getPrice());
                            listIteam.add(iteam);
                        }
                        int quantityProductInCart = 0;
                        int totalMoney = 0;
                        for (IteamModel iteam : listIteam) {
                            quantityProductInCart += iteam.getQuantity();
                            totalMoney += (iteam.getProduct().getPrice()) * (iteam.getQuantity());
                        }
                        session.getAttribute("quantityProductInCart");
                        session.getAttribute("totalMoney");
                        session.setAttribute("quantityProductInCart", quantityProductInCart);
                        session.setAttribute("order", order);
                        session.setAttribute("totalMoney", totalMoney);
                    }
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cart/index.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.getStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cart/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void removeProductInCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
            try {
                ProductModel product = new SpaBean().getByIDProduct(id);
                List<CategoriesModel> categories = new SpaBean().getAllCategories();
                request.setAttribute("categories", categories);
                HttpSession session = request.getSession();
                if (session.getAttribute("order") != null) {
                    OrdersModel order = (OrdersModel) session.getAttribute("order");
                    List<IteamModel> listIteam = order.getIteam();
                    for (int i = 0; i < listIteam.size(); i++) {
                            if (listIteam.get(i).getProduct().getId_product() == id) {
                                listIteam.get(i).setQuantity(listIteam.get(i).getQuantity()-1);
                                if(listIteam.get(i).getQuantity()==0){
                                    listIteam.remove(i);
                                }
                            }
                        }

                        int quantityProductInCart = 0;

                        int totalMoney = 0;
                        for (IteamModel iteam : listIteam) {
                            quantityProductInCart += iteam.getQuantity();
                            totalMoney += (iteam.getProduct().getPrice()) * (iteam.getQuantity());
                        }
                        session.getAttribute("quantityProductInCart");
                        session.getAttribute("totalMoney");
                        session.setAttribute("quantityProductInCart", quantityProductInCart);
                        session.setAttribute("order", order);
                        session.setAttribute("totalMoney", totalMoney);
                    }

                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cart/index.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.getStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/cart/index.jsp");
            dispatcher.forward(request, response);
        }
    }
    protected void payOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String name_customer = request.getParameter ("name_customer");
        int phone = Integer.parseInt (request.getParameter ("phone"));
        String address = (request.getParameter ("address"));

        HttpSession session = request.getSession();
        OrdersModel list = (OrdersModel) session.getAttribute("order");
        int id_orders = 0;
        try {
            id_orders = new OrdersDao().getIdHoaDon();


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        float total_money =0;
        for (int i=0;i<list.getIteam().size();i++){

            int id_product = list.getIteam().get(i).getProduct().getId_product();
            int amount = list.getIteam().get(i).getQuantity();
            float price = (float)list.getIteam().get(i).getProduct().getPrice();
             total_money +=(float) amount*price;
            OrderDetailModel orderDetail = new OrderDetailModel(id_orders,id_product,amount,price,total_money,name_customer,phone,address);
            OrdersDao ordersDao = new OrdersDao();
            try {
                ordersDao.createDetailOrder(orderDetail);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/cart/cartSussces.jsp");
        List<CategoriesModel> categories = null;
        try {
            categories = new SpaBean().getAllCategories();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        session.removeValue("order");
        session.removeValue("quantityProductInCart");
        request.setAttribute("categories", categories);
        request.setAttribute("message", "Gởi thông tin thanh toán thành công. Shop sẽ liên hệ trong 24h");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void createOrder(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/dd");
        Date date = new Date();
        String order_date = formatter.format(date);
        int id_employee = new EmployeeModel().getId_employee();
        try {
            int id_customer = new CustomerDao().getidkhachhang();
            OrdersModel orders = new OrdersModel(order_date, id_employee, id_customer);
            new OrdersDao().createOrder(orders);
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name_customer = request.getParameter ("name_customer");
        int phone = Integer.parseInt (request.getParameter ("phone"));
        String address = (request.getParameter ("address"));
        CustomerModel customer = new CustomerModel(name_customer,phone,address);
        CustomerDao customerDao = new CustomerDao();
        try {
            customerDao.createkhachhang(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}