package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static steps.BeforeStep.driver;

public class CityStep {
    WebElement cityElement = driver.findElement(By.xpath(
            "//div[@id='headerCityNameDynamic']/child::span"));
    WebElement fieldSearch = driver.findElement(By.id("select-basket-city-input"));
    WebElement btnCity = driver.findElement(By.xpath(
            "//a[contains(@class,'btn--empty city')]/child::span"));

    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));


    @When("Нажимаем на город")
    public void clickOnCity() {
        cityElement.click();

    }

    @And("Нажимаем кнопку выбрать другой")
    public void clickButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnCity));
        btnCity.click();
    }

    @And("Вводим в поиск {string}")
    public void enterInField(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select-basket-city-input")));
        fieldSearch.sendKeys(value);
        driver.findElement(By.xpath("//b[text()='" + value + "']")).click();
    }

    @Then("Проверка результата поиска: отобразился {string}")
    public void checkResult(String value) {
        Assertions.assertEquals(value, cityElement.getText()
                , "Город не отображается в разделе");
    }
}