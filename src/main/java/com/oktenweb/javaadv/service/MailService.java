package com.oktenweb.javaadv.service;

import com.oktenweb.javaadv.entity.User;

public interface MailService {

  void sendVerificationCode(User user);

}
