package com.study.servlet;

import com.study.entity.ToDo;
import com.study.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllTodosServlet extends HttpServlet {

    List<ToDo> todoList;

    public GetAllTodosServlet(List<ToDo> todoList) {
        this.todoList = todoList;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("todos", todoList);
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("todos.html", map);

        resp.getWriter().write(page);
    }
}
