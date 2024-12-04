package com.version.manager.service;

import com.version.manager.config.version.VersionProperties;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class AppVersionService {
  private final VersionProperties properties;

  public String getBuildTimeStamp() {
    String buildTimeStamp = null;
    String jarFilePath = System.getProperty(properties.getUserDir()) + properties.getTargetDir();
    log.info("Jar file path: {}", jarFilePath);
    try (JarFile jarFile = new JarFile(jarFilePath)) {
      Manifest manifest = jarFile.getManifest();
      if (manifest != null) {
        Attributes attributes = manifest.getMainAttributes();

        for (Map.Entry<Object, Object> entry : attributes.entrySet()) {
          String key = entry.getKey().toString();
          String value = entry.getValue().toString();
          if (properties.getBuildTimeStamp().equals(key)) {
            buildTimeStamp = value;
          }
        }
      }
    } catch (Exception e) {
      log.error("Error while reading manifest file", e);
    }
    return buildTimeStamp;
  }

}
