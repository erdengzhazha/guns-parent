package com.stylefeng.guns.api.user;

import com.stylefeng.guns.api.user.domain.User;
import com.stylefeng.guns.api.user.dto.UserDto;

public interface UserApi {

    int  isLogin(String username,String password);

    boolean regist(User user);

    boolean checkUsername(String username);

    UserDto getUserInfo(int uuid);

    UserDto updateUserInfo(UserDto userDto);
}
