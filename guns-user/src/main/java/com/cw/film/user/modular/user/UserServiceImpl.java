package com.cw.film.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.cw.film.user.dao.BackendUserTMapper;
import com.cw.film.user.model.BackendUserT;
import com.stylefeng.guns.api.service.UserApi;
import com.stylefeng.guns.api.domain.User;
import com.stylefeng.guns.api.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserApi.class)
public class UserServiceImpl implements UserApi {

  @Autowired
  private BackendUserTMapper backendUserTMapper;

  @Override
  public int isLogin(String username, String password) {
    //从数据库中查询用户账号密码
    BackendUserT backendUserT = new BackendUserT();
    backendUserT.setUserName(username);
    BackendUserT backendUserT1 = backendUserTMapper.selectOne(backendUserT);
    if(backendUserT1!=null){
      return backendUserT1.getUuid();
    }else{
      return 0;
    }
  }

  @Override
  public boolean regist(User user) {
    //将注册信息实体转化为数据实体
    BackendUserT backendUserT = new BackendUserT();
    backendUserT.setUserName(user.getUserName());
    //数据加密
    backendUserT.setUserPwd(user.getUserPwd());
    Integer insert = backendUserTMapper.insert(backendUserT);
    if(insert>0) {
      return true;
    }else{
      return false;
    }
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
