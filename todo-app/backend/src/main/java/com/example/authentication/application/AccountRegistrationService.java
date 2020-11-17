package com.example.authentication.application;

import com.example.authentication.application.entity.AccountEntity;
import com.example.authentication.application.entity.UserProfileEntity;
import nablarch.common.dao.UniversalDao;
import nablarch.core.repository.di.config.externalize.annotation.SystemRepositoryComponent;

import java.util.UUID;

@SystemRepositoryComponent
public class AccountRegistrationService {

  public void register(String userName, String password) {
    String userId = generateUserId();
    insertAccount(userId, password);
    insertUserProfile(userId, userName);
  }

  private String generateUserId() {
    return UUID.randomUUID().toString();
  }

  private void insertAccount(String userId, String password) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setUserId(userId);
    accountEntity.setPassword(password);
    UniversalDao.insert(accountEntity);
  }

  private void insertUserProfile(String userId, String userName) {
    UserProfileEntity userProfileEntity = new UserProfileEntity();
    userProfileEntity.setUserId(userId);
    userProfileEntity.setName(userName);
    UniversalDao.insert(userProfileEntity);
  }
}
