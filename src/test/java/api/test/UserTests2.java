package api.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	
	Faker faker;
	User userpayload;
	public Logger logger;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());	
		
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void testPostUser(){
		logger.info("************************Creating User***************");
		Response response=UserEndPoints2.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************************ User is created***************");
	}
	
	@Test(priority = 2)
	public void getUserbyName() {
		logger.info("************************Reading User Info***************");
		Response response=UserEndPoints2.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);	
		
		logger.info("************************User info Displayed***************");
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		logger.info("************************Updating User***************");
		
		//Update data using payload
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		
		Response response=UserEndPoints2.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Checking data is update or not
		
		Response responseAfterUpdate=UserEndPoints.readUser(this.userpayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		logger.info("************************User is updated***************");
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		logger.info("************************Deleting User***************");
		Response response=UserEndPoints2.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************************User Deleted completed***************");
	}
	
}
