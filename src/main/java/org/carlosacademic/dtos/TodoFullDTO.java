package org.carlosacademic.dtos;

public record TodoFullDTO(
        TodoDTO todo,
        UserDTO user
) {
}
