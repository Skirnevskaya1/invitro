package steps;

import org.junit.After;

import static steps.BeforeStep.driver;

public class AfterStep {

    @After
    public void tearDown() {
        driver.quit();
    }
}
