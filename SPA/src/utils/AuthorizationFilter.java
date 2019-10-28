package utils;

import dao.impl.UserDAOImpl;
import model.UserModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AuthorizationFilter implements Filter {

    private ServletContext context;
    private Object userValidate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI ( );

        UserDAOImpl userDAO = new UserDAOImpl ( );
        if (url.startsWith ("/admin")) {
//            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
            String userName = request.getParameter ("username");
            String password = request.getParameter ("password");

            UserModel userModel = new UserModel ( );
            userModel.setUserName (userName);
            userModel.setPassword (password);

                try {
                    userValidate = userDAO.authenticateUser (userModel);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace ( );
                }
                if (userValidate != null) {
                    if (userValidate.equals ("admin")) {
                        filterChain.doFilter (servletRequest, servletResponse);
                    } else if (userValidate.equals ("user")) {
//                    response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=Not_permisson&alert=danger");
                        request.setAttribute ("message", "Not login");
                        RequestDispatcher dispatcher = request.getRequestDispatcher ("/views/admin/login.jsp");
                        dispatcher.forward (request, response);
                    }
                } else {
//                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=Not_login&alert=danger");
                    request.setAttribute ("message", "Not login not login not login");
                    RequestDispatcher dispatcher = request.getRequestDispatcher ("/views/admin/login.jsp");
                    dispatcher.forward (request, response);
                }
        }else{
                filterChain.doFilter (servletRequest, servletResponse);
            }

    }

    @Override
    public void destroy() {

    }
}
