package Pages;

import Pojo.UpdateData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Update {

	int bookingId = 1;

	public static Response updateBooking(String baseUrl, String endpoint, int bookingId, UpdateData data) {

		return RestAssured.given().contentType(ContentType.JSON)
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").body(data).when()
				.put(baseUrl + endpoint + "/" + bookingId);
	}

}
