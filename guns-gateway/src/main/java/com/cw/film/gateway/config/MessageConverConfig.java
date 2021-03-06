package com.cw.film.gateway.config;

import com.cw.film.gateway.modular.auth.converter.WithSignMessageConverter;
import com.stylefeng.guns.api.config.DefaultFastjsonConfig;
import com.cw.film.gateway.config.properties.RestProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 签名校验messageConverter
 *
 * @author fengshuonan
 * @date 2017-08-25 16:04
 */
@Configuration
public class MessageConverConfig {

  @Bean
  @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "sign-open", havingValue = "true", matchIfMissing = true)
  public WithSignMessageConverter withSignMessageConverter() {
    WithSignMessageConverter withSignMessageConverter = new WithSignMessageConverter();
    DefaultFastjsonConfig defaultFastjsonConfig = new DefaultFastjsonConfig();
    withSignMessageConverter.setFastJsonConfig(defaultFastjsonConfig.fastjsonConfig());
    withSignMessageConverter.setSupportedMediaTypes(defaultFastjsonConfig.getSupportedMediaType());
    return withSignMessageConverter;
  }
}
