package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;

public class BeforeStep {

    @Когда("^открыт сайт '([^']*)'$")
    public void openWebSite(String url) {
        Selenide.open(url);
    }
}
