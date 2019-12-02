package com.study.rest;


import com.study.dao.TodoDao;
import com.study.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoRestController {
//    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    TodoDao todoDao;

//    @GetMapping("/todos")
//    @ResponseBody
//    public String getAll() throws JsonProcessingException {
//        List<ToDo> list = todoDao.getAll();
//        String json = objectMapper.writeValueAsString(list);
//        return json;
//    }

    @GetMapping("/todos")
    @ResponseBody
    public List<ToDo> getAll() {
        List<ToDo> list = todoDao.getAll();
        return list;
    }

    @GetMapping("/todos/{id}")
    @ResponseBody
    public ToDo getById(@PathVariable int id) {
        return todoDao.getById(id);
    }
}
