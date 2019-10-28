package utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/product")
public class CounterFilter implements Filter {
    private int count = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        count = 0;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        count++;
        System.out.println (count);
        filterChain.doFilter (servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
