package com.study.controller;

import com.study.dao.TodoDao;
import com.study.entity.ToDo;
import com.study.templater.PageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TodoController {
    @Autowired
    private TodoDao todoDao;

    @RequestMapping(path = "/todos", method = RequestMethod.GET)
    public void showAllPage(HttpServletResponse httpServletResponse) throws IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("todos", todoDao.getAll());
        String page = pageGenerator.getPage("todos.html", parameters);

        httpServletResponse.getWriter().write(page);
    }

    @RequestMapping(path = "/todos/add", method = RequestMethod.GET)
    public void showAddPage(HttpServletResponse httpServletResponse) throws IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("addTodo.html", null);
        httpServletResponse.getWriter().write(page);
    }

    @RequestMapping(path = "/todos/add", method = RequestMethod.POST)
    public void addProduct(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        String name = httpServletRequest.getParameter("name");

        todoDao.add(new ToDo(id, name));

        httpServletResponse.sendRedirect("/todos");
    }
}
