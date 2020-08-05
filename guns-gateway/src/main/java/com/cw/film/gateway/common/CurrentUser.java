package com.cw.film.gateway.common;

/**
 * 获取当前对象的工具类
 */
public class CurrentUser {
  //线程绑定的存储空间
  private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

  public static void saveUserID(String userId) {
    threadLocal.set(userId);
  }

  public static String getCurrentId() {
    return threadLocal.get();
  }

//    public static void saveUserinfo(UserDto userDto){
//
//        threadLocal.set(userDto);
//
//    }
//    public static UserDto getCurrentUser(){
//        return threadLocal.get();
//    }
}
