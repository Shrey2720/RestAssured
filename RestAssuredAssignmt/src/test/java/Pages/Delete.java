package Pages;

import Pojo.UpdateData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Delete {
	public static Response deleteBooking(String baseUrl, String endpoint, int bookingId, UpdateData data) {
		return RestAssured.given().contentType(ContentType.JSON)
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").cookie("Cookie", "token=<token_value>")
				.body(data).when().delete(baseUrl + endpoint + "/" + bookingId);
	}
}
