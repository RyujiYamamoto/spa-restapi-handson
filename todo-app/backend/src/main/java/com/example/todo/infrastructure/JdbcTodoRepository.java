package com.example.todo.infrastructure;

import com.example.todo.application.TodoRepository;
import com.example.todo.domain.*;
import nablarch.core.repository.di.config.externalize.annotation.SystemRepositoryComponent;

import java.util.List;

@SystemRepositoryComponent
public class JdbcTodoRepository implements TodoRepository {

  @Override
  public List<Todo> list(UserId userId) {
    return List.of(new Todo(new TodoId(2001L), new TodoText("やること１"), TodoStatus.COMPLETED),
        new Todo(new TodoId(2002L), new TodoText("やること２"), TodoStatus.INCOMPLETE));
  }
}
