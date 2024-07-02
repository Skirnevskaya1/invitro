package steps;

import io.cucumber.java.ru.Когда;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;


public class RequestStep {
    public Response response;

    @Когда("^отправляем запрос '([^']*)'$")
    public void sendRequest(String code) {
        response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("https://www.invitro.ru/local/ajax/current-city.php?CODE=" + code)
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        String actualValue = response.jsonPath().getString("city");
        Assertions.assertEquals(code, actualValue);
    }
}
