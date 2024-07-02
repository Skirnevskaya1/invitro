package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;


public class AnalysisCodeStep {
    public final SelenideElement
            searchInputField = $x("//input[@name='q']").as("Поиск на сайте "),
            codeResult = $x("//div[contains(@class,'head--number')]/span")
                    .as("Результат поиска код анализа");

    @Когда("^вводим код анализа '([^']*)' в поле поиска$")
    public void enterCode(String code) {
        searchInputField.setValue(code).pressEnter();
    }

    @Тогда("^проверяем код анализа '([^']*)' с найденным результатом$")
    public void checkResult(String code) {
        Assertions.assertEquals("№ " + code, codeResult.getText()
                , "Код анализа не совпадает с результатом в разделе");
    }
}
