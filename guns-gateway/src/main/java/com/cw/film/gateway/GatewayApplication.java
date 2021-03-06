package com.cw.film.gateway;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class GatewayApplication {

  public static void main(String[] args) {

    SpringApplication.run(GatewayApplication.class, args);
  }
}
