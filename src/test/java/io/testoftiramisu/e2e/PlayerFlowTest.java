package io.testoftiramisu.e2e;

import io.testoftiramisu.pages.BasePage;
import io.testoftiramisu.pages.GamePage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
@DisplayName("User flow E2E tests")
public class PlayerFlowTest extends BaseTest {

  @Test
  @DisplayName("User should open the game, play a round and close the game.")
  void userFlowTest() {

    GamePage page = openGamePage();

    page.sitPlayer().playRound().unseatPlayer().closeGame();
  }

  private GamePage openGamePage() {
    return new BasePage()
        .openBaseUrl()
        .acceptCookies()
        .pressDealMeInButton()
        .acceptAgeRestrictions();
  }
}
