package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	@Test(priority = 1, dataProvider = "dp",dataProviderClass = DataProviders.class)
	public void testPostUser(String UserID, String UserName, String	FirstName, String LastName, String Email, String Password, String Phone) {
		
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstname(FirstName);
		userPayload.setLastname(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);	
		
		Response response=UserEndPoints.createUser(userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "userNames", dataProviderClass = DataProviders.class)
	public void testGetUserByName(String UserName) {
		Response response=UserEndPoints.readUser(UserName);
	Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority = 3, dataProvider = "userNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String UserName) {
		Response response=UserEndPoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
