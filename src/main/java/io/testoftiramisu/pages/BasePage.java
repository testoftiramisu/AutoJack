package io.testoftiramisu.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.testoftiramisu.config.ConfigurationLoader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/** Page object for the base page. */
@Getter
@Slf4j
public class BasePage {
  private static final String ACCEPT_COOKIE = "#cookieAccept";
  private static final String DEAL_ME_IN = "#play_iframe_button";
  private static final String AGE_BUTTON = ".age-notice-button";
  private final String BASE_URL = ConfigurationLoader.getUrl();

  public BasePage openBaseUrl() {
    Selenide.open(BASE_URL);
    log.info("Open Base page " + BASE_URL + ".");
    return this;
  }

  public BasePage acceptCookies() {
    SelenideElement acceptCookie = $(ACCEPT_COOKIE);
    acceptCookie.should(visible);

    acceptCookie.click();
    acceptCookie.shouldNot(visible);
    log.info("Accept cookie.");
    return this;
  }

  public BasePage pressDealMeInButton() {
    $(DEAL_ME_IN).click();
    log.info("\"DEAL ME IN\" button pressed.");
    return this;
  }

  public GamePage acceptAgeRestrictions() {
    ElementsCollection ageNoticeButtons = $$(AGE_BUTTON);
    ageNoticeButtons.get(0).click();

    Selenide.switchTo().frame(0);
    log.info("Age confirmed.");

    return new GamePage();
  }
}
