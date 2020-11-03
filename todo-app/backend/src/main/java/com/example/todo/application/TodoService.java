package com.example.todo.application;

import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoId;
import com.example.todo.domain.TodoStatus;
import com.example.todo.domain.TodoText;
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

  public Todo addTodo(UserId userId, TodoText text) {
    TodoId todoId = todoRepository.nextId();
    Todo newTodo = new Todo(todoId, text, TodoStatus.INCOMPLETE);
    todoRepository.add(userId, newTodo);
    return newTodo;
  }
}
