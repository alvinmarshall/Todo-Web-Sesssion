package com.websession.todotask.service.impl;

import com.websession.todotask.domain.Todo;
import com.websession.todotask.dto.CreateTodoDto;
import com.websession.todotask.dto.EditTodoDto;
import com.websession.todotask.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

@Slf4j
class TodoServiceImplTest {
    @Mock
    private TodoRepository todoRepository;
    private TodoServiceImpl todoService;
    private CreateTodoDto createTodoDto;
    private EditTodoDto editTodoDto;
    private Todo fakeTodo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        todoService = new TodoServiceImpl(todoRepository);
        fakeTodo = new Todo();
        fakeTodo.setId(1);
        fakeTodo.setTitle("test any title");
        fakeTodo.setDescription("test any description");

    }

    @Test
    void createTodo() {
        Assertions.assertDoesNotThrow(() -> {
            createTodoDto = new CreateTodoDto("test any title", "test any description");
            Mockito.when(todoRepository.save(Mockito.any())).thenReturn(fakeTodo);
            Todo expected = todoService.createTodo(createTodoDto);
            Assertions.assertNotNull(expected);
            Assertions.assertEquals(expected.getId(), 1);
        });


    }

    @Test
    void editTodo() {
        Assertions.assertDoesNotThrow(() -> {
            editTodoDto = new EditTodoDto(1, "test some title", "test some description", true);
            Mockito.when(todoRepository.findById(Mockito.any())).thenReturn(Optional.of(fakeTodo));

            Todo newTodo = new Todo();
            newTodo.setId(editTodoDto.getId());
            newTodo.setTitle(editTodoDto.getTitle());
            newTodo.setDescription(editTodoDto.getDescription());
            newTodo.setCompleted(editTodoDto.isCompleted());

            Mockito.when(todoRepository.save(Mockito.any())).thenReturn(newTodo);
            Todo expected = todoService.editTodo(editTodoDto);
            Assertions.assertNotNull(expected);
        });
    }

    @Test
    void deleteTodo() {
    }
}