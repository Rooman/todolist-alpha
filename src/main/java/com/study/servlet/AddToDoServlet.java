package com.study.servlet;

import com.study.entity.ToDo;
import com.study.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddToDoServlet extends HttpServlet {

    List<ToDo> toDoList;

    public AddToDoServlet(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("addTodo.html", null);
        resp.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        toDoList.add(new ToDo(id, name));

        resp.sendRedirect("/todos");
    }
}
