package Pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBooking {

	public static Response getBooking(String baseUrl, String endpoint, int bookingId) {
		return RestAssured.get(baseUrl + endpoint + "/" + bookingId);
	}

}
