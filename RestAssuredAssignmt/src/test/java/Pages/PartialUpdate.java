package Pages;

import Pojo.UpdateData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PartialUpdate {
	int bookingId = 1;

	public static Response PartialupdateBooking(String baseUrl, String endpoint, int bookingId, UpdateData data) {

		return RestAssured.given().contentType(ContentType.JSON)
				.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").body(data).when()
				.patch(baseUrl + endpoint + "/" + bookingId);

	}
}
