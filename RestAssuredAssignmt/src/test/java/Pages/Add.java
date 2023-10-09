package Pages;

import Pojo.UpdateData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Add {

	public static Response addBooking(String baseUrl, String endpoint, UpdateData data) {
		return RestAssured.given().contentType(ContentType.JSON).body(data).when().post(baseUrl + endpoint);
	}
}
