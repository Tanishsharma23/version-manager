package com.version.manager.interceptor;

import com.version.manager.config.version.VersionProperties;
import com.version.manager.service.AppVersionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class MdcInterceptor implements HandlerInterceptor {

  private final AppVersionService versionService;
  private final VersionProperties properties;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler) {
    MDC.put(properties.getBuildTimeStamp(), versionService.getBuildTimeStamp());
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                              Object handler, Exception ex) {
    String mdcKey = properties.getBuildTimeStamp();
    if (mdcKey != null) {
      MDC.remove(mdcKey);
    }
  }
}
