package org.demoqa;

import com.github.javafaker.Faker;

public class TestData {

  private static Faker faker = new Faker();
  public static String firstName = faker.name().firstName();
  public static String lastName = faker.name().lastName();
  public static String fullName = faker.name().fullName();
  public static String email = faker.internet().emailAddress();
  public static String age = String.valueOf(faker.number().numberBetween(18, 80));
  public static String salary = String.valueOf(faker.number().numberBetween(1000, 10000));
  public static String department = faker.company().name();
  public static String rndLastName = getRandomName();
  public static String address = faker.address().fullAddress();

  private static String getRandomName() {
    String[] names = {"Vega", "Cantrell", "Gentry"};
    return getRandomItemFromArray(names);
  }

  private static String getRandomItemFromArray(String[] array){
    int index = faker.number().numberBetween(0, 2);
    return array[index];
  }

}
