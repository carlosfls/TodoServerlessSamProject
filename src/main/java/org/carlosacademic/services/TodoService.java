package org.carlosacademic.services;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.carlosacademic.dtos.TodoDTO;
import org.carlosacademic.exeptions.InvalidMessageException;
import org.carlosacademic.mappers.TodoMapper;
import org.carlosacademic.repositories.TodoRepository;
import org.carlosacademic.tables.DTodo;


public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }

    public void register(TodoDTO todo, LambdaLogger logger) {
        if (todo != null){
            DTodo dTodo = TodoMapper.toDTodo(todo);
            todoRepository.saveIfNotExist(dTodo, logger);
            return;
        }
        throw new InvalidMessageException("TodoDTO is null");
    }
}
