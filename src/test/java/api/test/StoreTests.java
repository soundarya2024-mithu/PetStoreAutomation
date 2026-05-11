package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	
	Faker faker;
	Store storePayload;
	Logger logger;
	
	
	@BeforeClass
	public void dataSetup() {
		faker=new Faker();
		storePayload=new Store();
		storePayload.setId(faker.number().numberBetween(1,10));
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.number().numberBetween(1, 5));
		storePayload.setShipDate("2026-05-11T15:57:29.912Z");
		storePayload.setStatus("placed");
		storePayload.setComplete(true);

		
		logger=LogManager.getLogger(this.getClass());
		
	}
	
	@Test(priority = 1)
	public void testPlaceOrder() {
		logger.info("****************Order placing************");
		Response response=StoreEndPoints.placeOrder(storePayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		logger.info("**************Order places successfully*************");
	}
	
	@Test(priority = 2)
	public void testGetOrder() {
		logger.info("****************Getting order by Orderid************");
		Response response=StoreEndPoints.getOrder(this.storePayload.getId());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****************order printed************");
	}
	
	@Test(priority = 3)
	public void testDeleteOrder() {
		logger.info("****************Deleting order by Orderid************");
		
		Response response=StoreEndPoints.deleteOrder(this.storePayload.getId());
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****************order Deleted successfully************");
		
	}
	
	@Test(priority = 4)
	public void testGetAllInventory() {
		logger.info("****************Getting all orders************");
		Response response=StoreEndPoints.getAllInventory();
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****************Displayed all orders successfully************");
	}

}
