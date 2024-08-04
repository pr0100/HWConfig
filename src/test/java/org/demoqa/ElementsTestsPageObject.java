package org.demoqa;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.ElementsPages;

public class ElementsTestsPageObject extends TestBase {

  protected static final Logger LOGGER = LogManager.getLogger();
  ElementsPages elementsPages = new ElementsPages();

  @Test
  @DisplayName("Успешное нажатие элемента radio button")
  void successfulRadioBtnClick() {
    elementsPages.openElementsPage()
        .openRadioPage()
        .buttonLikeSite()
        .checkRadBtnClick();
    LOGGER.info("Radio button successfully verified");
  }

  static Stream<String[]> provideData() {
    return Stream.of(
        new String[]{"Strelkov Stas", "test@mail.ru", "new street, 111, 123"},
        new String[]{"Nikita", "test2@m.com", "Old Town Road, 4"}
    );
  }

  @ParameterizedTest
  @MethodSource("provideData")
  @DisplayName("Заполнение текстовых полей")
  void fillingTextBox(String inputName, String inputMail, String inputAddress) {
    elementsPages.openElementsPage()
        .openTextPage()
        .setFullName(inputName)
        .setEmail(inputMail)
        .setAddress(inputAddress)
        .submitTextBox()
        .checkFullName(inputName)
        .checkMail(inputMail)
        .checkAddress(inputAddress);
    LOGGER.info("Text boxes successfully verified");
  }
}
