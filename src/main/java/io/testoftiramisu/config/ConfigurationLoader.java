package io.testoftiramisu.config;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Loads environmental variables from environment configuration file. */
@Slf4j
public class ConfigurationLoader {
  private static final String URL = "url";
  private static final String CONFIG_FILE = ".env.yml";
  private static final String BROWSER = "browser";
  private static Map<String, Object> environmentConfig;

  /** Returns url from provided environment configuration. */
  public static String getUrl() {
    return ConfigurationLoader.getEnvironment().get(URL).toString();
  }

  /** Returns browser from provided environment configuration. */
  public static String getBrowser() {
    return ConfigurationLoader.getEnvironment().get(BROWSER).toString();
  }

  /** Returns a shallow copy of the environment map. */
  private static Map<String, Object> getEnvironmentMap() {
    return new HashMap<>(environmentConfig);
  }

  private static Map<String, Object> getEnvironment() {
    if (environmentConfig == null) {
      String env = System.getProperty("env");

      if (env == null) {
        log.info("❗ No environment configuration is provided, local config file is used.");
        env = "local";
      }

      Environment environment = Environment.findByName(env);

      if (environment == null) {
        log.error("Unable to find Environment: " + env);
        throw new RuntimeException();
      }

      String configFile = Objects.requireNonNull(environment).getName() + CONFIG_FILE;
      log.info(configFile + " configuration file is used.");

      InputStream inputStream =
          ConfigurationLoader.class.getClassLoader().getResourceAsStream(configFile);
      environmentConfig = new Yaml().load(inputStream);
    }
    return getEnvironmentMap();
  }
}
