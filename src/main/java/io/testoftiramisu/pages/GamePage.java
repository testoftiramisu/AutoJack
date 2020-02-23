package io.testoftiramisu.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/** Page object for the game page. */
@Slf4j
public class GamePage {

  private static final String CANVAS = "canvas:nth-child(3)";
  private static final String BURGER_MENU = ".burgerMenu";
  private static final String CHIP = ".chip";
  private static final List<Integer> OFFSETS = Arrays.asList(0, -203, 203);
  private SelenideElement canvas;

  public GamePage() {
    $(BURGER_MENU).shouldBe(visible);
    log.info("Age confirmed.");
    canvas = $(CANVAS);
    Configuration.timeout = 5000;
  }

  public GamePage sitPlayer() {
    log.info("Trying to sit player on any available seat:");
    for (Integer offset : OFFSETS) {
      canvas.click(offset, 0);
      try {
        $(CHIP).shouldBe(visible);
        log.info("Player sit on place: " + (OFFSETS.indexOf(offset) + 1));
        break;
      } catch (ElementNotFound ex) {
        log.info("Seat " + (OFFSETS.indexOf(offset) + 1) + " seems to be occupied.");
      }
    }

    // 819x516
    // 203 x 42

    return this;
  }

  public GamePage playRound(String s) {

    return this;
  }

  public GamePage unsitPlayer() {
    canvas.click(-375, -240);
    log.info("Player unsitted");
    return this;
  }

  public void closeGame() {}
}
