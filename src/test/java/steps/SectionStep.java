package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class SectionStep {

    public final SelenideElement
            sectionMenuBtn = $x("//div[@id='buttonOpenPopupTargetSTATICSTRINGFORID']/span")
            .as("Кнопка раздела меню"),
            menuSection = $x("//div[@id='popupTargetSTATICSTRINGFORID']/a/span").as("Раскрытый раздел меню");

    @Когда("^нажмаем на раздел меню$")
    public void clickOnSection() {
        sectionMenuBtn.click();
    }

    @Когда("^выбираем раздел '([^']*)'$")
    public void clickOnSection(String value) {
        SelenideElement section = $x("(//span[text()='" + value + "'])[1]");
        if (section.getText().equals(value)) {
            section.click();
        } else Assertions.assertEquals(value, menuSection.getText(),
                "Указано недопустимое значение: " + value);
    }

    @Тогда("^проверяем раздел '([^']*)'$")
    public void checkSection(String value) {
        Assertions.assertEquals(value, sectionMenuBtn.getText(),
                "Ожидаемое наименование раздела не совпадает с фактическим");
    }
}
