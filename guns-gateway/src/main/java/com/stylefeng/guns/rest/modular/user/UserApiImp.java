package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserApi;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserApi.class)
public class UserApiImp implements UserApi{

    public boolean isLogin(String username,String password){
        return true;
    }
}
