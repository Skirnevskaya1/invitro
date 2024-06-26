package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RequestStep {
    private Response response;

    @When("Отправляем GET запрос к {string}")
    public void sendRequest(String endpoint) {
        response = RestAssured.get("https://www.invitro.ru" + endpoint);
    }

    @Then("Код ответа должен быть 200")
    public void setResponse(int expectedStatusCode) {
        assertThat(response.getStatusCode(), equalTo(expectedStatusCode));
    }

    @Then("Тело ответа должно содержать {string}")
    public void responseContains(String expectedBodyContent) {
        assertThat(response.getBody().asString(), containsString(expectedBodyContent));
    }
}
