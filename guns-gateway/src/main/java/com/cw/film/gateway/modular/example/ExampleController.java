package com.cw.film.gateway.modular.example;

import com.cw.film.gateway.common.CurrentUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 常规控制器
 *
 * @author fengshuonan
 * @date 2017-08-23 16:02
 */
@Controller
@RequestMapping("/hello")
public class ExampleController {

  @RequestMapping("")
  @ResponseBody
  public ResponseEntity hello() {
    // System.out.println(simpleObject.getUser());
    System.out.println(CurrentUser.getCurrentId());
    return ResponseEntity.ok("请求成功!");
  }
}
