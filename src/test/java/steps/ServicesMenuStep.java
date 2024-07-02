package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.ru.Когда;

import static com.codeborne.selenide.Selenide.$$x;

public class ServicesMenuStep {

    @Когда("^прокликивание меню и подгрупп$")
    public void clickOnMenu() {
        ElementsCollection menuItems = $$x("//ul[contains(@class,'side-bar-second')]");

        menuItems.asDynamicIterable().forEach(menuItem -> {
            menuItem.shouldBe(Condition.visible).click();
            menuItems.asDynamicIterable().forEach(SelenideElement::click);
        });
    }
}
