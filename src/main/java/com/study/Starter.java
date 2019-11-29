package com.study;

import com.study.entity.ToDo;
import com.study.servlet.AddToDoServlet;
import com.study.servlet.GetAllTodosServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) throws Exception {


        GetAllTodosServlet getAllTodosServlet = new GetAllTodosServlet();
        AddToDoServlet addToDoServlet = new AddToDoServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(getAllTodosServlet), "/todos");
        context.addServlet(new ServletHolder(addToDoServlet), "/todos/add");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
