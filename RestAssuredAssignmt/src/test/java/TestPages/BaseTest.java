package TestPages;

import io.restassured.response.Response;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import Pages.Add;
import Pages.GetBooking;
import Pages.Update;
import Pojo.UpdateData;

public class BaseTest {

	Logger log = Logger.getLogger(BaseTest.class);
	UpdateData.BookingDates bd = new UpdateData.BookingDates();
	UpdateData data = new UpdateData();

	private static final String BASE_URL = "https://restful-booker.herokuapp.com/";
	private static final String BOOKING_ENDPOINT = "booking";

	@Test
	public void testGetBooking() {
		int bookingId = 1;

		Response response = GetBooking.getBooking(BASE_URL, BOOKING_ENDPOINT, bookingId);

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();

		System.out.println("Response Status Code: " + statusCode);
		log.info("Status Code is :" + statusCode);
		System.out.println("Response Body: " + responseBody);
		log.info("Response Body: " + responseBody);
		log.info("Booking are successfully recieved ");
	}

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
		log.info("Booking Details Added Successfully ");

	}

	@Test
	public void testUpdateBooking() {
		int bookingId = 1;
		data.setFirstname("Shrey");
		data.setLastname("Khanna1");
		data.setTotalprice(6000);
		data.setBookingdates(bd);
		data.setDepositpaid(true);
		data.setAdditionalneeds("breakfast");
		bd.setCheckin("2023-18-08");
		bd.setCheckout("2034-19-08");

		Response response = Update.updateBooking(BASE_URL, BOOKING_ENDPOINT, bookingId, data);

		int statusCode = response.getStatusCode();
		String responseBody = response.getBody().asString();
		System.out.println("Response Status Code: " + statusCode);
		log.info("Status Code is :" + statusCode);
		System.out.println("Response Body: " + responseBody);
		log.info("Response Body: " + responseBody);
		log.info("Booking Details Updated Successfully ");
	}

}
