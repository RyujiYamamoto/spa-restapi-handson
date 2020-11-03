package com.example.todo.infrastructure;

import com.example.todo.application.TodoRepository;
import com.example.todo.domain.*;
import com.example.todo.infrastructure.entity.TodoEntity;

import nablarch.common.dao.EntityList;
import nablarch.common.dao.UniversalDao;
import nablarch.core.repository.di.config.externalize.annotation.SystemRepositoryComponent;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SystemRepositoryComponent
public class JdbcTodoRepository implements TodoRepository {

  @Override
  public List<Todo> list(UserId userId) {
    Map<String, String> condition = Map.of("userId", userId.value());
    EntityList<TodoEntity> todoEntities =
        UniversalDao.findAllBySqlFile(TodoEntity.class, "FIND_BY_USERID", condition);

    return todoEntities.stream().map(this::createTodo).collect(Collectors.toList());
  }

  private Todo createTodo(TodoEntity entity) {
    return new Todo(new TodoId(entity.getTodoId()), new TodoText(entity.getText()),
        entity.getCompleted() ? TodoStatus.COMPLETED : TodoStatus.INCOMPLETE);
  }
}
