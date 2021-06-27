package com.websession.todotask.controller;

import com.websession.todotask.domain.Todo;
import com.websession.todotask.dto.CreateTodoDto;
import com.websession.todotask.dto.EditTodoDto;
import com.websession.todotask.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todos")
@Slf4j
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody() CreateTodoDto createTodoDto) {
        log.info("request todo {}", createTodoDto);
        return new ResponseEntity<>(todoService.createTodo(createTodoDto), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PutMapping
    public ResponseEntity<?> editTodo(@RequestBody() EditTodoDto editTodoDto) throws Exception {
        return new ResponseEntity<>(todoService.editTodo(editTodoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void removeTodo(@PathVariable("id") int todoId) throws Exception {
        log.info("todo id: {}", todoId);
        todoService.deleteTodo(todoId);
    }
}
