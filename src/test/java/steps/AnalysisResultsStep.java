package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

import static steps.BeforeStep.driver;
import static steps.BeforeStep.wait;

public class AnalysisResultsStep {
    WebElement btnAnalysisResults = driver.findElement(By.xpath(
            "//a[@rel='index nofollow']/child::span"));

    @When("Нажимаем на кнопку {string}")
    public void clickOnBtnAnalysisResults() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAnalysisResults));
        btnAnalysisResults.click();
    }

    @Then("Проверяем заголовок страницы, равен {string}")
    public void checkTheHeader() {
        // Сохранение идентификатора текущей вкладки
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        // Ожидание и переключение на новую вкладку
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Проверка заголовка новой страницы
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));

//        // Закрытие новой вкладки и возвращение к исходной вкладке
//        driver.close();
//        driver.switchTo().window(originalWindow);
    }

    @When("Нажимаем на {string}")
    public void clickOn(String arg0) {

    }

    @Then("Проверяем, что поля выделены красным")
    public void checkFields() {

    }

    @And("Проверяем, что появилось предупреждение {string}")
    public void checkWarning(String arg0) {
    }
}
