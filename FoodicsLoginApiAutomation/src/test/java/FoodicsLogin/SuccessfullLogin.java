package FoodicsLogin;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class SuccessfullLogin {
	
  @Test
  public void testSuccessfulLogin() {
	  
	  given()
      .body("{\"email\":\"merchant@foodics.com\",\"password\":\"123456\"}")
      .header("Content-Type", "application/json")
      .header("X-XSRF-TOKEN", "eyJpdiI6IjlVUURvb2NteHZSQ1BERExhR2RIcUE9PSIsInZhbHVlIjoiSjNaalMwcElXOVBEOGJHL01CeCtPOVR5Vlh3Zk10WDNyNjFKY253SUNPMVFzYk95ZHFTS1k2VFk2b2VTdHdwY2w0NytJUVE0V20xczVFYzM0S2RjaUlVL3k1dlY3RGtQaG1Pc3VJcGg0Y3hoSHZsLzk0dXpRbVJ1N0tQbkZlTzkiLCJtYWMiOiJkOWNlNTlmNmJkNzlkYmQ1MGE5NjNmNWY3MjY4MGUzMzFlOWY4ZmNhNDYxMzM5NmQwZGQyYWMwNmJiOGVkYmQ1IiwidGFnIjoiIn0=")
      .when()
          .post("https://pay2.foodics.dev/cp_internal/login")
      .then()
          .statusCode(200)
          .assertThat()
          	.body("token", notNullValue());
	  
  }
  
}
