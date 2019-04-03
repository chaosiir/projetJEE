package com.projetJEE;

import com.google.gson.Gson;
import com.projetJEE.User.User;
import com.projetJEE.User.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="AuthFilter", urlPatterns={"*"})
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("filter "+new Gson().toJson(req.getSession()));

        HttpSession session = req.getSession();
        if(session==null){
            goToLogin(chain, req, res);
            return;
        }

        User user = (User) session.getAttribute("user");
        Boolean auth = (Boolean) session.getAttribute("auth");
        if (auth == null || !auth || user==null) {
            goToLogin(chain, req, res);
            return;
        }
        chain.doFilter(req,res); //nothing to do

        // Check if the user is accessing login page
        /*
        if (req.getRequestURI().equals(
                req.getContextPath() + "/pages/login.jsp")) {
            if (true){//isLoggedIn) {
                // Redirect to landing or home page
                res.sendRedirect(req.getContextPath()
                        + "/pages/home.jsp");
            } else {
                // Otherwise, nothing to do if he has not logged in
                // pass the request along the filter chain
                chain.doFilter(request, response);
            }
        } else {
            // For all other pages,
            if (true){//isLoggedIn) {
                // Nothing to do
                chain.doFilter(request, response);
            } else {
                // Redirect to login page if he has not logged in
                res.sendRedirect(req.getContextPath() + "/pages/login.jsp");
            }
        }*/
    }

    private String goToLogin(FilterChain chain, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String loginURL = req.getContextPath() + "/login";
        if (req.getRequestURI().equals(loginURL)) {
            chain.doFilter(req,res); //nothing to do
        }else{
            res.sendRedirect(loginURL);
        }
        return loginURL;
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }
}
