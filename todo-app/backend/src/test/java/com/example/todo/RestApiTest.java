package com.example.todo;

import com.example.openapi.OpenApiValidator;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.RestMockHttpRequest;
import nablarch.test.core.http.SimpleRestTestSupport;

import org.junit.ClassRule;
import org.junit.Test;
import org.openapi4j.core.validation.ValidationException;

import java.nio.file.Paths;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class RestApiTest extends SimpleRestTestSupport {

  public static OpenApiValidator openApiValidator = new OpenApiValidator(
      Paths.get("rest-api-specification/openapi.yaml"));

  @Test
  public void RESTAPIでToDo一覧が取得できる() throws ValidationException {
    RestMockHttpRequest request = get("/api/todos");
    HttpResponse response = sendRequest(request);

    assertStatusCode("ToDo一覧の取得", HttpResponse.Status.OK, response);

    String responseBody = response.getBodyString();

    assertThat(responseBody, hasJsonPath("$", hasSize(2)));

    assertThat(responseBody, hasJsonPath("$[0].id", equalTo(2001)));
    assertThat(responseBody, hasJsonPath("$[0].text", equalTo("やること１")));
    assertThat(responseBody, hasJsonPath("$[0].completed", equalTo(true)));

    assertThat(responseBody, hasJsonPath("$[1].id", equalTo(2002)));
    assertThat(responseBody, hasJsonPath("$[1].text", equalTo("やること２")));
    assertThat(responseBody, hasJsonPath("$[1].completed", equalTo(false)));

    openApiValidator.validate("getTodos", request, response);
  }
}
