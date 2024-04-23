package api.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.Order;

import io.restassured.response.Response;

public class OrderTest {

	Faker faker;
	
	Order order;
	@BeforeClass
	public void setupData() 
	{
		faker = new Faker();
		
		order = new Order();	
		
		Date futureDate = faker.date().future(30, java.util.concurrent.TimeUnit.DAYS);

        // Convert the Date to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(futureDate.toInstant(), ZoneId.systemDefault());

		order.setId(faker.idNumber().hashCode());
		order.setComplete(true);
		order.setPetId(33333);
		order.setQuantity(1);
		order.setShipDate(localDateTime);
		order.setStatus("placed");

	}
	
	@Test(priority=1)
	public void testPostPet()
	{
		Response response = UserEndPoints.createOrder(order);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 500);	
	}
	
	@Test(priority=2)
	public void testGetPet()
	{
		Response response = UserEndPoints.readOrder((int) this.order.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	@Test(priority=3)
	public void testDeletePet()
	{
		Response response = UserEndPoints.deleteOrder((int) this.order.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
}
