package com.cw.film.gateway.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.service.*;
import org.springframework.stereotype.Component;

@Component
public class Client {
  @Reference(interfaceClass = UserApi.class)
  private UserApi userApi;

  public void run() {
    System.out.println("进入了 run方法");
    userApi.isLogin("fdsa", "12645");
  }
}
