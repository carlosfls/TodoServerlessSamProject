package org.carlosacademic.mappers;


import org.carlosacademic.dtos.TodoDTO;
import org.carlosacademic.tables.DTodo;

public class TodoMapper {

    public static DTodo toDTodo(TodoDTO todoDTO){
        DTodo dTodo = new DTodo();
        dTodo.setUserId(todoDTO.userId());
        dTodo.setId(todoDTO.id());
        dTodo.setTitle(todoDTO.title());
        dTodo.setCompleted(todoDTO.completed());
        return dTodo;
    }

    public static TodoDTO toTodoDto(DTodo dTodo){
        return new TodoDTO(
                dTodo.getUserId(),
                dTodo.getId(),
                dTodo.getTitle(),
                dTodo.isCompleted());
    }
}
