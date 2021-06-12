package com.websession.todotask.service;

import com.websession.todotask.domain.Todo;
import com.websession.todotask.dto.CreateTodoDto;
import com.websession.todotask.dto.EditTodoDto;

public interface TodoService {
     Todo createTodo(CreateTodoDto todo);
     Todo editTodo(EditTodoDto todo) throws Exception;
     void deleteTodo(int todoId) throws Exception;
}
