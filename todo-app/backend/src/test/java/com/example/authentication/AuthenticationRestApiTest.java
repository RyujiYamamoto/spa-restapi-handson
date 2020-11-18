package com.example.authentication;

import com.example.openapi.OpenApiValidator;
import nablarch.fw.web.HttpResponse;
import nablarch.fw.web.RestMockHttpRequest;
import nablarch.test.core.http.SimpleRestTestSupport;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.nio.file.Paths;
import java.util.Map;

public class AuthenticationRestApiTest extends SimpleRestTestSupport {

  public static OpenApiValidator openApiValidator =
      new OpenApiValidator(Paths.get("rest-api-specification/openapi.yaml"));

  @Test
  public void RESTAPIでサインアップできる() throws Exception {
    RestMockHttpRequest request =
        post("/api/signup").setHeader("Content-Type", MediaType.APPLICATION_JSON)
            .setBody(Map.of("userName", "signup-test", "password", "pass"));
    HttpResponse response = sendRequest(request);

    assertStatusCode("サインアップ", HttpResponse.Status.NO_CONTENT, response);

    openApiValidator.validate("signup", request, response);
  }

  @Test
  public void 名前が登録済みの場合_サインアップに失敗して409になる() throws Exception {
    RestMockHttpRequest firstRequest =
        post("/api/signup").setHeader("Content-Type", MediaType.APPLICATION_JSON)
            .setBody(Map.of("userName", "signup-conflict-test", "password", "pass"));
    sendRequest(firstRequest);

    RestMockHttpRequest secondRequest =
        post("/api/signup").setHeader("Content-Type", MediaType.APPLICATION_JSON)
            .setBody(Map.of("userName", "signup-conflict-test", "password", "pass"));
    HttpResponse response = sendRequest(secondRequest);

    assertStatusCode("サインアップ", HttpResponse.Status.CONFLICT, response);

    openApiValidator.validate("signup", secondRequest, response);
  }
}
