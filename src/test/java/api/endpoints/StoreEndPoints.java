package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response placeOrder(Store payload) {
		
		Response response=given()
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
							.body(payload)
						.when()
							.post(Routes.storePost_url);
		return response;
	}
	
	public static Response getOrder(int orderId) {
		
		Response response=given()
							.accept(ContentType.JSON)
							.pathParam("orderId", orderId)
						.when()
							.get(Routes.storeGet_url);
		return response;
	}
	
	public static Response deleteOrder(int orderId) {
		Response response=given()
							.accept(ContentType.JSON)
							.pathParam("orderId", orderId)
						.when()
							.delete(Routes.storeDelete_url);
		return response;
	}
	
	public static Response getAllInventory() {
		Response response=given()
			.accept(ContentType.JSON)
		.when()
			.get(Routes.storeGetAllInventory_url);
		return response;
	}

}
