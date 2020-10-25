package com.example.todo.application;

import com.example.todo.domain.Todo;
import com.example.todo.domain.UserId;
import nablarch.core.repository.di.config.externalize.annotation.SystemRepositoryComponent;

import java.util.List;

@SystemRepositoryComponent
public class TodoService {

  private final TodoRepository todoRepository;

  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public List<Todo> list(UserId userId) {
    return todoRepository.list(userId);
  }

}
