package io.testoftiramisu;

import com.codeborne.selenide.Configuration;
import io.testoftiramisu.config.ConfigurationLoader;
import org.junit.jupiter.api.BeforeAll;

class BaseTest {

  @BeforeAll
  static void setUp() {
    Configuration.browser = ConfigurationLoader.getBrowser();
  }
}
