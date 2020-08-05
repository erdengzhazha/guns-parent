package com.stylefeng.guns.api.service;

import com.stylefeng.guns.api.domain.User;
import com.stylefeng.guns.api.dto.UserDto;

/**
 * 关于用户的接口
 */
public interface UserApi {

  /**
   * 用于登录
   *
   * @param username
   * @param password
   * @return
   */
  int isLogin(String username, String password);

  /**
   * 注册
   *
   * @param user
   * @return
   */
  boolean regist(User user);

  /**
   * 查看用户是否存在
   *
   * @param username
   * @return
   */
  boolean checkUsername(String username);

  /**
   * 查询用户信息
   *
   * @param uuid
   * @return
   */
  UserDto getUserInfo(int uuid);

  /**
   * 更新用户信息
   *
   * @param userDto
   * @return
   */
  UserDto updateUserInfo(UserDto userDto);
}
