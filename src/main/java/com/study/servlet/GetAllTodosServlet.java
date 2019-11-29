package com.study.servlet;

import com.study.dao.TodoDao;
import com.study.entity.ToDo;
import com.study.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllTodosServlet extends HttpServlet {

    TodoDao todoDao = TodoDao.getInstance();

    public GetAllTodosServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todos", todoDao.getAll());
        String page = pageGenerator.getPage("todos.html", parameters);

        resp.getWriter().write(page);
    }
}
