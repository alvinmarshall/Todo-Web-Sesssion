package com.websession.todotask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EditTodoDto {
    private final int id;
    private final String title;
    private final String description;

    @JsonProperty("completed")
    private final boolean isCompleted;
}
