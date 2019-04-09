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
        List<ToDo> todoList = new ArrayList<>();

        todoList.add(new ToDo(1, "Buy phone"));
        todoList.add(new ToDo(2, "Clean room"));

        GetAllTodosServlet getAllTodosServlet = new GetAllTodosServlet(todoList);
        AddToDoServlet addToDoServlet = new AddToDoServlet(todoList);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(getAllTodosServlet), "/todos");
        context.addServlet(new ServletHolder(addToDoServlet), "/todos/add");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
