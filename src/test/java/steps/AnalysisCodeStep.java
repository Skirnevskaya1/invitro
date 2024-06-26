package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static steps.BeforeStep.driver;

public class AnalysisCodeStep {
    WebElement searchField = driver.findElement(By.xpath(
            "//div[@class='invitro_header-search']/descendant::input[@name='q']"));
    WebElement nameResultCode = driver.findElement(By.xpath(
            "//div[@class='analyzes-item__head--number']/child::span"));
    WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));


    @When("Вводим код анализа в поле поиска")
    public void enterAnalysisCode(String code) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.click();
        searchField.sendKeys(code + Keys.ENTER);
    }

    @Then("Проверка кода с найденным результатом")
    public void checkResult(String code) {
        Assertions.assertEquals(code, nameResultCode.getText()
                , "Код анализа не совпадает с результатом в разделе");
    }

}
