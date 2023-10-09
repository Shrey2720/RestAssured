package TestPages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import Pages.Add;
import Pages.Delete;
import Pages.PartialUpdate;
import Pojo.UpdateData;
import io.restassured.response.Response;

public class BaseTest2 {
	Logger log = Logger.getLogger(BaseTest2.class);

	UpdateData.BookingDates bd = new UpdateData.BookingDates();
	UpdateData data = new UpdateData();

	private static final String BASE_URL = "https://restful-booker.herokuapp.com/";
	private static final String BOOKING_ENDPOINT = "booking";

	@Test
	public void testAddBooking() {
		data.setFirstname("Shrey");
		data.setLastname("Khanna");
		data.setTotalprice(6000);
		data.setBookingdates(bd);
		data.setDepositpaid(true);
		data.setAdditionalneeds("breakfast");
		bd.setCheckin("2023-18-08");
		bd.setCheckout("2034-19-08");
		Response response = Add.addBooking(BASE_URL, BOOKING_ENDPOINT, data);
		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Response Status Code: " + statusCode);
		log.info("Status Code is :" + statusCode);
		System.out.println("Response Body: " + responseBody);
		log.info("Response Body: " + responseBody);
		log.info("Booking are successfully Added ");
	}

	@Test

	public void testPartialUpdateBooking() {
		int bookingId = 1;
		data.setFirstname("Shrey");
		data.setLastname("Khanna2");

		Response response = PartialUpdate.PartialupdateBooking(BASE_URL, BOOKING_ENDPOINT, bookingId, data);

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Response Status Code: " + statusCode);
		log.info("Status Code is :" + statusCode);
		System.out.println("Response Body: " + responseBody);
		log.info("Response Body: " + responseBody);
		log.info("Booking are Partially Updated ");
	}

	@Test

	public void testDeleteBooking() {
		int bookingId = 2;

		Response response = Delete.deleteBooking(BASE_URL, BOOKING_ENDPOINT, bookingId, data);

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Response Status Code: " + statusCode);
		log.info("Status Code is :" + statusCode);
		System.out.println("Response Body: " + responseBody);
		log.info("Response Body: " + responseBody);
		log.info("Booking are successfully Deleted ");

		assertEquals(statusCode, 201);
	}
}
