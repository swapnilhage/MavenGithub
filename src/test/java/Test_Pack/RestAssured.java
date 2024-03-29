package Test_Pack;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
public class RestAssured {

	@org.testng.annotations.Test
	public void Test() {
		
//		io.restassured.RestAssured.baseURI= "https://reqres.in";
//		given().log().all().queryParam("page","2").header("Content-Type","application/json")
//		.when().get("api/users")
//		.then().log().all().assertThat().statusCode(200);
		
		io.restassured.RestAssured.baseURI= "https://reqres.in";
		String response = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}")
		.when().post("api/users")
		.then().log().all().assertThat().statusCode(201).body("job", equalTo("leader")).extract().response().asString();
		
		System.out.println(response);
		
	//	JsonPath js = new JsonPath(response);
		
	}

}
