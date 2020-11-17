package com.example.authentication.api;

import com.example.authentication.application.AccountRegistrationService;
import nablarch.core.repository.di.config.externalize.annotation.SystemRepositoryComponent;
import nablarch.core.validation.ee.ValidatorUtil;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/")
@SystemRepositoryComponent
public class AuthenticationAction {

  private final AccountRegistrationService registrationService;

  public AuthenticationAction(AccountRegistrationService registrationService) {
    this.registrationService = registrationService;
  }

  @Path("/signup")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void signup(SignupRequest requestBody) {
    ValidatorUtil.validate(requestBody);

    registrationService.register(requestBody.userName, requestBody.password);
  }

  public static class SignupRequest {
    @NotNull
    public String userName;

    @NotNull
    public String password;
  }
}
