package com.study.controller;

import com.study.dao.TodoDao;
import com.study.entity.ToDo;
import com.study.templater.PageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TodoController {
    @Autowired
    private TodoDao todoDao;

    @RequestMapping(path = "/todos", method = RequestMethod.GET)
    public String showAllPage(Model model) {
        model.addAttribute("todos", todoDao.getAll());
        return "todos";
    }

    @RequestMapping(path = "/todos/add", method = RequestMethod.GET)
    public String showAddPage() {
        return "addTodo";
    }

//    @RequestMapping(path = "/todos/add", method = RequestMethod.POST)
//    public String addProduct(@RequestParam int id, @RequestParam("name") String todoName) throws IOException {
//        todoDao.add(new ToDo(id, todoName));
//
//        return "redirect:/todos";
//    }

    @RequestMapping(path = "/todos/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute ToDo toDo) {
        todoDao.add(toDo);

        return "redirect:/todos";
    }

    @GetMapping(path = "/todo/{id}")
    @ResponseBody
    public String getById(@PathVariable int id) {
        return String.valueOf(todoDao.getById(id));
    }
}
