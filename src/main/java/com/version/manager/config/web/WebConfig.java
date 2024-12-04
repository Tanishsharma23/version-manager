package com.version.manager.config.web;

import com.version.manager.interceptor.MdcInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  private final MdcInterceptor mdcInterceptor;

  public WebConfig(MdcInterceptor mdcInterceptor) {
    this.mdcInterceptor = mdcInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(mdcInterceptor);
  }

}
