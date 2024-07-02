package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class AnalysisResultsStep {

    public final SelenideElement
            analysisResultsBtn = $x("//a[@rel='index nofollow']/span").
            as("Кнопка результаты анализов"),
            resultsPage = $x("//h2").as("Заголовок страницы"),
            orderNumField = $x("//input[@name='orderNumber']").as("Поле Код ИНЗ"),
            birthField = $x("//input[@name='birthday']").as("Поле с датой дня рождения"),
            lastNameField = $x("//input[@name='lastName']").as("Поле с Фамилией"),
            captcha = $x("//div[@class='RecaptchaV2_error__ItTTx UnauthResultsPage_captcha__olzeR']").as("Капча"),
            warningMessage = $x("//div[@class='UnauthResultsPage_error__m2C-2']").as("предупреждение, что поля обязательны для заполнения");

    @Когда("^нажимаем на кнопку получить результаты анализов$")
    public void getAnalysisResults() {
        analysisResultsBtn.click();
        switchTo().window(0, Duration.ofSeconds(5));
    }

    @Тогда("^проверяем отображение заголовка страницы '([^']*)'$")
    public void checkPageTitle(String msg) {
        Assertions.assertEquals(resultsPage.getText(),
                msg, "Отображение заголовка не соответствует ожидаемому результату");
    }

    @Когда("^нажимаем на кнопку '(.*)'$")
    public void clickOnResultPage(String value) {
        $x("//button[text()='" + value + "']").click();
    }

    @Тогда("^проверяем, что поля выделены красным$")
    public void checkFields() {
        String redColor = "rgba(232, 236, 237, 1)";
        Assertions.assertEquals(redColor, orderNumField.getCssValue("border-left-color"),
                "Ожидаемый цвет не совпадает с фактическим");
        Assertions.assertEquals(redColor, birthField.getCssValue("border-left-color"),
                "Ожидаемый цвет не совпадает с фактическим");
        Assertions.assertEquals(redColor, lastNameField.getCssValue("border-left-color"),
                "Ожидаемый цвет не совпадает с фактическим");
        Assertions.assertEquals(redColor, captcha.getCssValue("border-left-color"),
                "Ожидаемый цвет не совпадает с фактическим");
    }

    @Тогда("^проверяем, что появилось предупреждение '([^']*)'$")
    public void checkWarningMessage(String msg) {
        Assertions.assertEquals(warningMessage.getAttribute("textContent"), msg,
                "Отображение предупреждения не соответствует ожидаемому результату");
    }

    @Когда("^в поле '(.*)' вводим дату '([^']*)'$")
    public void inputDate(String field, String date) {
        if (field.equals("Дата рождения")) {
            birthField.click();
            birthField.sendKeys(date);
            birthField.shouldBe(Condition.visible);
        }
    }

    @Когда("^в поле '(.*)' вводим значение '([^']*)'$")
    public void inputValue(String field, String value) {
        if (field.equals("Код ИНЗ")) {
            orderNumField.setValue(value).shouldBe(Condition.visible);
        } else if (field.equals("Фамилия")) {
            lastNameField.setValue(value).shouldBe(Condition.visible);
        }
    }

    @Тогда("^проверяем отображение в поле '(.*)' значение '([^']*)'$")
    public void checkResultFields(String field, String value) {
        if (field.equals("код ИНЗ")) {
            orderNumField.shouldHave(Condition.value(value));
        } else if (field.equals("Дата рождения")) {
            birthField.shouldHave(Condition.value(value));
        } else if (field.equals("Фамилия")) {
            lastNameField.shouldHave(Condition.value(value));
        }
    }
}
