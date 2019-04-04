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

    private ArrayList<Object> publicPages;
    private String loginURL;

    public AuthFilter() {

    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println("filter "+new Gson().toJson(req.getSession()));

        HttpSession session = req.getSession(true);//get session or create one


        User user = (User) session.getAttribute("user");
        Boolean auth = (Boolean) session.getAttribute("auth");
        if(auth==null)auth=false;

        //filter unauthenticated clients
        if (!auth && !publicPages.contains(req.getRequestURI())) {
            System.out.println("authFilter : redirect to login -> auth:"+auth+" login:"+user.getLogin());
            goToLoginIfNeeded(req, res, chain);
            return;
        }

        //accept all request for unauthenticated clients on public pages
        if(!auth && publicPages.contains(req.getRequestURI())){
            chain.doFilter(request,response);
            return;
        }


        // if authenticated and on public page, redirect to /Home
        if(publicPages.contains(req.getRequestURI())){
            System.out.println("authFilter : redirect to home -> auth:"+auth+" user:"+user);
            res.sendRedirect(req.getContextPath()+"/Home");
            return;
        }

        //filter unauthorized pages
        if(req.getRequestURI().equals(req.getContextPath()+"/Users")){
            if(user.getRights() == User.Rights.ADMIN){
                chain.doFilter(req, res); //nothing to do
                return;
            }
        }else{
            //check request method, to cancel unauthorized modification/deletion
            if (req.getMethod().equals("POST") && user.getRights() == User.Rights.USER) {
                System.out.println("authFilter : user '"+user.getLogin()+"' tried to modify/delete on "+req.getServletPath());
                res.sendRedirect(req.getContextPath() + "/");
            }else
                chain.doFilter(req, res); //nothing to do
            return;
        }

        res.sendRedirect(req.getContextPath()+"/Home");
    }

    private void goToLoginIfNeeded(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (publicPages.contains(req.getRequestURI())) {
            chain.doFilter(req, res); //nothing to do
        }else{
            res.sendRedirect(loginURL);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
        String contextPath = fConfig.getServletContext().getContextPath();
        publicPages = new ArrayList<>();
        loginURL = contextPath+ "/login";
        publicPages.add(loginURL);
        publicPages.add(contextPath+ "/register");
        publicPages.add(contextPath+ "/mdp");
        publicPages.add(contextPath+ "/answer");
    }
}
