package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class CityStep {

    public final SelenideElement
            cityBtn = $x("//*[@id='headerCityNameDynamic']/span")
            .as("Кнопка с названием города"),
            cityChangeBtn = $x("//a[contains(@class,'btn--empty city')]/span")
                    .as("Кнопка выбрать другой город"),
            cityInputField = $x("//*[@id='select-basket-city-input']").as("Поле ввода");


    @Когда("^нажимаем на кнопку город$")
    public void clickOnCity() {
        cityBtn.click();
    }

    @Когда("^нажимаем на кнопку выбрать другой$")
    public void clickOnChangeCity() {
        cityChangeBtn.shouldBe(Condition.visible).click();
    }

    @Когда("^в поле поиска вводим значение '([^']*)'$")
    public void inputCity(String value) {
        cityInputField.shouldBe(Condition.visible).click();
        cityInputField.setValue(value);
    }

    @Когда("^нажимаем на результат поиска '([^']*)'$")
    public void clickResult(String value) {
        $x("//b[text()='" + value + "']").shouldBe(Condition.visible).click();
    }

    @Тогда("^проверяем отображение города '([^']*)' в разделе медицинские услуги")
    public void checkResult(String value) {
        Assertions.assertEquals(value, cityBtn.getText()
                , "Город не отображается в разделе");
    }
}