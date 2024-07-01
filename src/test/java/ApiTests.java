import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    //Verify that the response code is 200 (OK)
    @Test
    public void testBoredAPIResponseCode() {
        given()
                .when()
                .get("https://www.boredapi.com/api/activity")
                .then()
                .statusCode(200);
    }

    //Verify that the response contains a valid JSON format
    @Test
    public void testBoredAPIResponseFormat() {
        given()
                .when()
                .get("https://www.boredapi.com/api/activity")
                .then()
                .assertThat()
                .contentType("application/json");
    }

    //Verify that the response contains fields like "activity", "type", "participants"
    @Test
    public void testBoredAPIResponseFields() {
        given()
                .when()
                .get("https://www.boredapi.com/api/activity")
                .then()
                .assertThat()
                .body("activity", notNullValue())
                .body("type", notNullValue())
                .body("participants", notNullValue());
    }

    //Verify that the response contains a non-empty activity
    @Test
    public void testBoredAPIResponseCorrectness() {
        given()
                .when()
                .get("https://www.boredapi.com/api/activity")
                .then()
                .assertThat()
                .body("activity", not(emptyString()));
    }
}
