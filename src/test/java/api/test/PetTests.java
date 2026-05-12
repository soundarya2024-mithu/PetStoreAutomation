package api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.Pet;
import api.payload.PetCatagory;
import api.payload.PetTags;
import io.restassured.response.Response;

public class PetTests {
	
	Pet petPayload;
	Faker faker;
	
	@BeforeClass
	public void dataSetup() {
		faker=new Faker();
		petPayload=new Pet();
		PetCatagory catagory=new PetCatagory();
		catagory.setId(faker.number().numberBetween(1, 10));
		catagory.setName("Dog");
		PetTags tags=new PetTags();
		tags.setId(faker.number().numberBetween(1, 10));
		tags.setName("pet Animal");
		
		petPayload.setId(faker.number().numberBetween(1, 10));
		petPayload.setCatagory(catagory);
		petPayload.setName("Doggie");
		petPayload.setPhotoUrls(Arrays.asList("photo1"));
		petPayload.setTags(Arrays.asList(tags));
		petPayload.setStatus("available");
		
	}
	@Test(priority = 1)
	public void testCreatePet() {
		Response response=PetEndPoints.createPet(petPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void testUpdatePet() {
		petPayload.setName("Fox");
		petPayload.setStatus("available");
		
		Response response=PetEndPoints.updatePet(petPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void testGetpets() {
		Response response=PetEndPoints.getPet(this.petPayload.getId());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void testDeletePets() {
		Response response=PetEndPoints.deletePet(this.petPayload.getId());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
