package com.unrgo.javaee_1.servlets;

import com.unrgo.javaee_1.dao.UserDAO;
import com.unrgo.javaee_1.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.concurrent.atomic.AtomicReference;
import static  com.unrgo.javaee_1.model.User.ROLE.ADMIN;
import static  com.unrgo.javaee_1.model.User.ROLE.USER;



@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "Sergey", "1", ADMIN));
        dao.get().add(new User(2, "User", "1", USER));

        ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}