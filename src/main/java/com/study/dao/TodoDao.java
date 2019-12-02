package com.study.dao;

import com.study.entity.ToDo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {
    private static TodoDao todoDao = new TodoDao();

    List<ToDo> todoList = new ArrayList<ToDo>() {
        {
            add(new ToDo(1, "Buy phone"));
            add(new ToDo(2, "Clean room"));
        }
    };

    private TodoDao() {
    }

    public static TodoDao getInstance() {
        return todoDao;
    }

    public void add(ToDo toDo) {
        todoList.add(toDo);
    }

    public ToDo getById(int id) {
        return todoList.get(id - 1);
    }

    public List<ToDo> getAll() {
        return todoList;
    }
}
