package com.websession.todotask.service;

import com.websession.todotask.domain.Todo;
import com.websession.todotask.dto.CreateTodoDto;
import com.websession.todotask.dto.EditTodoDto;

import java.util.List;

public interface TodoService {
    Todo createTodo(CreateTodoDto todo);

    Todo editTodo(EditTodoDto todo) throws Exception;

    List<Todo> getTodos();

    void deleteTodo(int todoId) throws Exception;
}
