package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static steps.BeforeStep.driver;

public class ServicesMenuStep {

    List<WebElement> menuItems = driver.findElements(By.xpath(
            "//a[contains(@class,'side-bar-second__link side-bar-second')]"));
    List<WebElement> menuSibItems = driver.findElements(By.xpath(
            "//a[@class='result-item__title']"));
    WebElement btnShow = driver.findElement(By.xpath(
            "//div[contains(@class, 'btn-icon btn-icon--fill ripple btn-more')]/child::span"));

    @When("Прокликиваем меню и по подгруппам")
    public void clickMainMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            WebElement menuItem = menuItems.get(i);
            menuItem.click();
            driver.navigate().back();
            menuItems = driver.findElements(By.xpath("//*[contains(@class,'side-bar')]/child::a"));
        }
    }

    @Then("Фиксируем, что вернулось значение true")
    public void checkMainMenuItems(boolean val) {
        System.out.println(val);
        Assertions.assertTrue(val, "Актуальный результат: " + val);
    }
}
