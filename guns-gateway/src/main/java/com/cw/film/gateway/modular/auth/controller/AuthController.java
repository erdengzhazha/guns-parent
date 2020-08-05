package com.cw.film.gateway.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.service.UserApi;
import com.cw.film.gateway.modular.auth.controller.dto.AuthRequest;
import com.cw.film.gateway.modular.auth.controller.dto.AuthResponse;
import com.cw.film.gateway.modular.auth.util.JwtTokenUtil;
import com.cw.film.gateway.modular.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Reference(interfaceClass = UserApi.class)
  private UserApi userApi;

//    @Resource(name = "simpleValidator")
//    private IReqValidator reqValidator;

  @RequestMapping(value = "${jwt.auth-path}")
  public ResponseVo createAuthenticationToken(AuthRequest authRequest) {
    //userApi.isLogin("dfa","123456789");
    boolean validate = true;
    Integer userid = userApi.isLogin(authRequest.getUserName(),authRequest.getPassword());
    if (userid == null) {
      validate = false;
    }
    if (validate) {
      final String randomKey = jwtTokenUtil.getRandomKey();
      final String token = jwtTokenUtil.generateToken("" + userid, randomKey);
      return ResponseVo.success(new AuthResponse(token, randomKey));
    } else {
      return ResponseVo.serviceFail("用户名或者密码错误");
    }
  }
}
