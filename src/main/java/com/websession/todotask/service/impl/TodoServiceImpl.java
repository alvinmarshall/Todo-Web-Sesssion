package com.websession.todotask.service.impl;

import com.websession.todotask.domain.Todo;
import com.websession.todotask.dto.CreateTodoDto;
import com.websession.todotask.dto.EditTodoDto;
import com.websession.todotask.repository.TodoRepository;
import com.websession.todotask.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public Todo createTodo(CreateTodoDto todo) {
        Todo createTodo = new Todo();
        createTodo.setTitle(todo.getTitle());
        createTodo.setDescription(todo.getDescription());
        return todoRepository.save(createTodo);
    }

    @Override
    public Todo editTodo(EditTodoDto todo) throws Exception {
        Optional<Todo> optionalTodo = todoRepository.findById(todo.getId());
        if (optionalTodo.isEmpty()) throw new Exception("todo id is not found");
        Todo newTodo = optionalTodo.get();
        newTodo.setTitle(todo.getTitle());
        newTodo.setDescription(todo.getDescription());
        newTodo.setCompleted(todo.isCompleted());
        return todoRepository.save(newTodo);
    }

    @Override
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @Override
    public void deleteTodo(int todoId) throws Exception {
        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
        if (optionalTodo.isEmpty()) throw new Exception("todo id is not found");
        todoRepository.delete(optionalTodo.get());
    }
}
