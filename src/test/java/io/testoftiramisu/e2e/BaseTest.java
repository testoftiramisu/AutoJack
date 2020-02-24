package io.testoftiramisu.e2e;

import com.codeborne.selenide.Configuration;
import io.testoftiramisu.config.ConfigurationLoader;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;
import java.util.logging.Logger;

/** Base test class. */
class BaseTest {

  @BeforeAll
  static void setUp() {
    disableSeleniumLogs();

    Configuration.browser = ConfigurationLoader.getBrowser();
    Configuration.browserSize = "1024x768";
    Configuration.timeout = 30000;
  }

  /** Disables ChromeDriverService native loggers. */
  public static void disableSeleniumLogs() {
    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
  }
}
