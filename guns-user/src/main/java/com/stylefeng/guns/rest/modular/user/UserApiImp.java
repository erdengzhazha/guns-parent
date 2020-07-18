package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserApi;
import com.stylefeng.guns.api.user.domain.User;
import com.stylefeng.guns.api.user.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserApi.class)
public class UserApiImp implements UserApi{

    @Override
    public int isLogin(String username, String password) {
        return 0;
    }

    @Override
    public boolean regist(User user) {
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        return false;
    }

    @Override
    public UserDto getUserInfo(int uuid) {
        return null;
    }

    @Override
    public UserDto updateUserInfo(UserDto userDto) {
        return null;
    }
}
