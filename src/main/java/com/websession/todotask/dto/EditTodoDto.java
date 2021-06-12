package com.websession.todotask.dto;

import lombok.Data;

@Data
public class EditTodoDto {
    private final int id;
    private final String title;
    private final String description;
    private final boolean isCompleted;
}
