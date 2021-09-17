package com.unrgo.javaee_1.servlets.filters;

import com.unrgo.javaee_1.dao.UserDAO;
import com.unrgo.javaee_1.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;


import static java.util.Objects.nonNull;


@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter( ServletRequest request,
                          ServletResponse response,
                          FilterChain filterChain)

            throws IOException, ServletException {

         HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;

         String login = req.getParameter("login");
         String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
         AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

         HttpSession session = req.getSession();

        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            User.ROLE role = (User.ROLE) session.getAttribute("role");
            moveToMenu(req, res, role);


        } else if (dao.get().userIsExist(login, password)) {

            User.ROLE role = dao.get().getRoleByLoginPassword(login, password);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            moveToMenu(req, res, role);

        } else {
            moveToMenu(req, res, User.ROLE.UNKNOWN);
        }
    }

    private void moveToMenu( HttpServletRequest req,
                             HttpServletResponse res,
                             User.ROLE role)
            throws ServletException, IOException {

        if (role.equals(User.ROLE.ADMIN)) {
            req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);
        } else if (role.equals(User.ROLE.USER)) {
            req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
        }
    }


    @Override
    public void destroy() {
    }

}