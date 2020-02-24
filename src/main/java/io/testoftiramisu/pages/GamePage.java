package io.testoftiramisu.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/** Page object for the game page. */
@Slf4j
public class GamePage {

  private static final String CANVAS = "canvas:nth-child(3)";
  private static final String BURGER_MENU = ".burgerMenu";
  private static final String CHIP = ".chip";
  private static final String CLOSE_BUTTON =
      "//div[@class='hero-section__content-frame hero-section__iframe']/div[@class='hero-section__close-button']";
  private static final String GAME_IN_PROGRESS = "//button[@class=' positionRelative pointer']";
  private static final List<Integer> OFFSETS = Arrays.asList(0, -203, 203);
  private SelenideElement canvas;

  public GamePage() {
    $(BURGER_MENU).shouldBe(visible);
    log.info("Age confirmed.");
    canvas = $(CANVAS);
  }

  public GamePage sitPlayer() {
    Configuration.timeout = 5000;
    boolean playerSeated = false;

    log.info("Trying to sit player on any available seat:");
    while (!playerSeated) {
      for (Integer offset : OFFSETS) {
        canvas.click(offset, 30);
        try {
          $x(GAME_IN_PROGRESS).should(Condition.disappear);
          $(CHIP).shouldBe(visible);
          log.info("Player sit on place: " + (OFFSETS.indexOf(offset) + 1));
          playerSeated = true;
          break;
        } catch (ElementNotFound ex) {
          log.info("Seat " + (OFFSETS.indexOf(offset) + 1) + " seems to be occupied.");
        }
      }
    }
    return this;
  }

  public GamePage playRound() {
    $(CHIP).doubleClick();
    log.info("A bet is made.");

    Configuration.timeout = 45000;
    $(CHIP).should(disappear);
    log.info("Game is in progress");

    $(CHIP).shouldBe(appear);
    return this;
  }

  public GamePage unseatPlayer() {
    canvas.click(-370, 235);
    log.info("Player unseated.");
    return this;
  }

  public void closeGame() {
    Configuration.timeout = 10000;
    Selenide.switchTo().defaultContent();

    $x(CLOSE_BUTTON).click();
    log.info("Game closed.");
  }
}
