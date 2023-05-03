package FoodicsLogin;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class UnsuccessfulLogin {

	@Test
	public void testUnsuccessfulLogin() {

		given()
        .body("{\"email\":\"merchant@foodics.com\",\"password\":\"password122\"}")
        .header("Content-Type", "application/json")
        .header("X-XSRF-TOKEN", "eyJpdiI6Ing1ZmtVbTRlRnRSR0w4cmc1T3J1QUE9PSIsInZhbHVlIjoiTmh1NHhKbFVCYUlnMFJsZFluMmFWanJONHZxRjEydGZtZklULy96bjNwTk1VeWtHKzZ3RUovTHhkbzNrV2hVR0p6Y0FlM0VNV2ZZZ0xNTlJHRko0Qk4ycGQ0S3JYMThuUHV6ZjFkRHRab3J3Rk00R05wck95ejMyMlZuSWJVbWoiLCJtYWMiOiI0OGZjYzNmYzIyNmJlNTBiM2Y0MGEwMjViOWFkMTM4OGQ5ZDMyZTkzMDU4OTU4NDA5OTAyM2RiNTZiMjliZGZiIiwidGFnIjoiIn0=")
    .when()
        .post("https://pay2.foodics.dev/cp_internal/login")
    .then()
        .statusCode(401)
        .assertThat()
            .body("message", not(nullValue()))
            .body("message", equalTo("Invalid email or password"));
	}

}


