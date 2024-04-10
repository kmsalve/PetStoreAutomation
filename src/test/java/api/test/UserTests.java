package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

//User Model testcases
public class UserTests {
	
	Faker faker;
	User userPayload;
	//CRUD tests
	@BeforeClass
	public void setUpData()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setUsername(faker.name().username());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());	
	}
	
	@Test(priority=1)
	public void testPostUser() 
	{	
		Response res = UserEndPoints.createUser(userPayload);
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetUser() 
	{	
		Response res = UserEndPoints.readUser(this.userPayload.getUsername());
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	 public void testPutUser() 
	{	
		//update data
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndPoints.updateUSer(this.userPayload.getUsername(),userPayload);
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	
		//checking after update
		
		Response resAfterupdate = UserEndPoints.readUser(this.userPayload.getUsername());
		AssertJUnit.assertEquals(resAfterupdate.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void testDeleteUser() 
	{	
		Response res = UserEndPoints.deleteUSer(this.userPayload.getUsername());
		res.then().log().all();
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	}
	
	
}
