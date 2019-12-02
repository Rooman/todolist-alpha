package com.study.filter;

import com.study.dao.SecurityService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityFilter implements Filter {
    private SecurityService securityService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext rootWebApplicationContext = WebApplicationContextUtils.
                getRequiredWebApplicationContext(servletContext);

        securityService =
                (SecurityService) rootWebApplicationContext.
                        getBean("securityService");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String userToken = request.getHeader("user-token");
        if (securityService.isValid(userToken)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }

        ((HttpServletResponse) servletResponse).sendRedirect("/login");

    }

    @Override
    public void destroy() {

    }
}
