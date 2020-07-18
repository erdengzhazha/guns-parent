package com.stylefeng.guns.rest.common;

import com.stylefeng.guns.api.user.dto.UserDto;

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
