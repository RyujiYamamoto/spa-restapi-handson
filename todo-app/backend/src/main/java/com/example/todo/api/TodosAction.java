package com.example.todo.api;

import com.example.todo.domain.*;

import com.example.todo.application.TodoService;
import nablarch.core.repository.di.config.externalize.annotation.SystemRepositoryComponent;
import nablarch.core.validation.ee.ValidatorUtil;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@SystemRepositoryComponent
@Path("/todos")
public class TodosAction {

  private final TodoService todoService;

  public TodosAction(TodoService todoService) {
    this.todoService = todoService;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<TodoResponse> get() {
    UserId userId = new UserId("1001"); // ダミーID
    List<Todo> todos = todoService.list(userId);
    return todos.stream().map(todo -> new TodoResponse(todo.id(), todo.text(), todo.status()))
        .collect(Collectors.toList());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public TodoResponse post(PostRequest requestBody) {
    ValidatorUtil.validate(requestBody);

    UserId userId = new UserId("1002");
    TodoText text = new TodoText(requestBody.text);

    Todo todo = todoService.addTodo(userId, text);

    return new TodoResponse(todo.id(), todo.text(), todo.status());
  }

  public static class PostRequest {
    @NotNull
    // TODO: 他に必要な精査は何だろう？
    public String text;
  }

  public static class TodoResponse {
    public final Long id;

    public final String text;

    public final Boolean completed;

    public TodoResponse(TodoId id, TodoText text, TodoStatus status) {
      this.id = id.value();
      this.text = text.value();
      this.completed = status == TodoStatus.COMPLETED;
    }
  }

}