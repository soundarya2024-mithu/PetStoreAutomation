package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.aventstack.extentreports.model.Report;

import api.payload.Pet;
import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static Response createPet(Pet payload) {
		Response response=given()
							.body(payload)
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
						.when()
							.post(Routes.petPost_url);
		return response;
				
	}
	
	public static Response updatePet(Pet payload) {
		Response response=given()
							.body(payload)
							.accept(ContentType.JSON)
							.contentType(ContentType.JSON)
						.when()
							.put(Routes.petPut_url);
		return response;
	}
	
	public static Response getPet(int petId) {
		Response response=given()
							.pathParam("petId", petId)
							.accept(ContentType.JSON)
						.when()
							.get(Routes.petGet_url);
		return response;
	}
	
	public static Response deletePet(int petId) {
		Response response=given()
							.pathParam("petId", petId)
							.accept(ContentType.JSON)
						.when()
							.delete(Routes.petDelete_url);
		return response;		
	}
}
