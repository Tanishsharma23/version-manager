package com.version.manager.config.version;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class VersionProperties {
  @Value("${version.manager.client.target.dir}")
  String targetDir;
  @Value("${version.manager.client.user.dir}")
  String userDir;
  @Value("${version.manager.client.build.timestamp.key}")
  String buildTimeStamp;
}
