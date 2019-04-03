package com.projetJEE;

import com.google.gson.Gson;
import com.projetJEE.User.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

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
            goToLoginIfNeeded(chain, req, res);
            return;
        }

        User user = (User) session.getAttribute("user");
        Boolean auth = (Boolean) session.getAttribute("auth");
        if (auth == null || !auth || user==null) {
            goToLoginIfNeeded(chain, req, res);
            return;
        }

        if(req.getRequestURI().equals(req.getContextPath()+"/Users")){
            if(user.getRights() == User.Rights.ADMIN){
                chain.doFilter(req,res); //nothing to do
                return;
            }
        }else{
            chain.doFilter(req,res); //nothing to do
        }

        res.sendRedirect(req.getContextPath()+"/Home");
    }

    private String goToLoginIfNeeded(FilterChain chain, HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ArrayList<String> publicPages = new ArrayList<>();
        String loginURL = req.getContextPath() + "/login";
        publicPages.add(loginURL);
        publicPages.add(req.getContextPath() + "/register");
        publicPages.add(req.getContextPath() + "/mdp");
        if (publicPages.contains(req.getRequestURI())) {
            chain.doFilter(req,res); //nothing to do
        }else{
            res.sendRedirect(loginURL);
        }
        return loginURL;
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }
}
