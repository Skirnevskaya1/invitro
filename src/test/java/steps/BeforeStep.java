package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BeforeStep {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Given("Открываем сайт {string}")
    public void openWebSite(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }
}
