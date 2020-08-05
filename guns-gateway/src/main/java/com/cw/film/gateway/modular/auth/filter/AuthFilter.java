package com.cw.film.gateway.modular.auth.filter;

import com.cw.film.gateway.modular.user.Client;
import com.cw.film.gateway.modular.vo.ResponseVo;
import com.stylefeng.guns.api.base.tips.ErrorTip;
import com.stylefeng.guns.api.util.RenderUtil;
import com.cw.film.gateway.common.CurrentUser;
import com.cw.film.gateway.common.exception.BizExceptionEnum;
import com.cw.film.gateway.config.properties.JwtProperties;
import com.cw.film.gateway.modular.auth.util.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对客户端请求的jwt token验证过滤器
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:04
 */
public class AuthFilter extends OncePerRequestFilter {

  private final Log logger = LogFactory.getLog(this.getClass());

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtProperties jwtProperties;

  @Autowired
  private Client client;
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    if (request.getServletPath().equals("/" + jwtProperties.getAuthPath())) {
      System.out.println("我调用了接口 run()");
      client.run();
      chain.doFilter(request, response);
      return;
    }
    //System.out.println("我执行了doFilter");
    //配置忽略列表
    String ignoreUrl = jwtProperties.getIgnoreUrl();
    String[] ignoreUrls = ignoreUrl.split(",");
    for (String a : ignoreUrls) {
      if (a.equals(request.getServletPath())) {
        chain.doFilter(request, response);
        return;
      }
    }

    final String requestHeader = request.getHeader(jwtProperties.getHeader());
    String authToken = null;

    if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
      authToken = requestHeader.substring(7);
      System.out.println("authToken" + authToken);
      //通过token获取userid,并且将他存到threadlocal
      String userid = jwtTokenUtil.getUsernameFromToken(authToken);
      if (userid == null) {
        return ;
      } else {
        System.out.println("保存的userid  = " + userid);
        CurrentUser.saveUserID(userid);
      }
      //验证token是否过期,包含了验证jwt是否正确
      try {
        boolean flag = jwtTokenUtil.isTokenExpired(authToken);
        if (flag) {
          RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_EXPIRED.getCode(), BizExceptionEnum.TOKEN_EXPIRED.getMessage()));
          return;
        }
      } catch (JwtException e) {
        //有异常就是token解析失败
        RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
        return;
      }
    } else {
      //header没有带Bearer字段
      RenderUtil.renderJson(response, new ErrorTip(BizExceptionEnum.TOKEN_ERROR.getCode(), BizExceptionEnum.TOKEN_ERROR.getMessage()));
      return;
    }
    chain.doFilter(request, response);
  }
}