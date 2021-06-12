package com.websession.todotask.dto;

import lombok.Data;

@Data
public class CreateTodoDto {
    private final String title;
    private final String description;
}
