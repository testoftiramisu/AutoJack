package io.testoftiramisu.pages;

import com.codeborne.selenide.Selenide;
import io.testoftiramisu.config.ConfigurationLoader;
import lombok.Getter;

@Getter
public class BasePage {
  private final String BASE_URL = ConfigurationLoader.getUrl();

  public void openBaseUrl() {
    Selenide.open(BASE_URL);
  }
}
