package org.demoqa;

import static org.demoqa.TestData.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.WebTablesPage;

public class WebTablesPageObjectTests extends TestBase {

  WebTablesPage webTablesPage = new WebTablesPage();
  protected static final Logger LOGGER = LogManager.getLogger();

  @Test
  @DisplayName("Добавление новой строки в таблицу при помощи формы")
  void successfulAddNewRecord() {
    webTablesPage.openElementsPage()
        .openWebPage()
        .addNewRecord()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setMail(email)
        .setAge(age)
        .setSalary(salary)
        .setDepartment(department)
        .submitBtn()
        .checkNewRecord(firstName);

    LOGGER.info("New record added");
  }

  @Test
  @DisplayName("Форма регистрации осталась открытой из-за незаполнения обязательных полей")
  void registrationFormNotClose() {
    webTablesPage.openElementsPage()
        .openWebPage()
        .addNewRecord()
        .setFirstName(firstName)
        .submitBtn()
        .checkRegistrFormOpen();

    LOGGER.info("Registration Form still open");
  }

  @Test
  @DisplayName("Закрытие формы регистрации нажатием кнопки Esc")
  void registrationFormCloseByEsc() {
    webTablesPage.openElementsPage()
        .openWebPage()
        .addNewRecord()
        .sendKeyEscape()
        .checkRegistrFormClose();

    LOGGER.info("Registration Form closed");
  }

  @Test
  @DisplayName("Изменение поля возраст у записи случайной записи")
  void successfulEditAgeInRecord() {
    webTablesPage.openElementsPage()
        .openWebPage()
        .openEditForm(rndLastName)
        .clearAge()
        .setAge(age)
        .submitBtn()
        .checkEditAgeInRecord(rndLastName, age);

    LOGGER.info("Age edited");
  }
}
