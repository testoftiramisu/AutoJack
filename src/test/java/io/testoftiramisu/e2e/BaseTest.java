package io.testoftiramisu.e2e;

import com.codeborne.selenide.Configuration;
import io.testoftiramisu.config.ConfigurationLoader;
import org.junit.jupiter.api.BeforeAll;

/** Base test class. */
class BaseTest {

  @BeforeAll
  static void setUp() {
    Configuration.browser = ConfigurationLoader.getBrowser();
    Configuration.browserSize = "1024x768";
    Configuration.timeout = 30000;
  }
}
