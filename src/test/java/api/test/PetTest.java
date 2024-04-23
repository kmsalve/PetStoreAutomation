package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.Pet;
import api.payload.Pet.Category;
import api.payload.Pet.Tag;
import io.restassured.response.Response;

public class PetTest {

	Faker faker;
	Pet petPayload;
	Category cat;
	Tag tag;
	
	Logger logger;
	
	@BeforeClass
	public void setupData() 
	{
		faker = new Faker();
		
		petPayload = new Pet();	
		
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setName(faker.animal().name());
		
		
		//Generate log here
		
		logger = LogManager.getLogger(this.getClass());
		
		logger.info("*********** Started *********");
	}
	
	@Test(priority=1)
	public void testPostPet()
	{
		//log
		logger.info("*********** Pet User *********");
		
		
		
		Response response = UserEndPoints.createPet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		//log
				logger.info("*********** Pet is created *********");
	}
	
	@Test(priority=2)
	public void testGetPetbyName()
	{
		//log
				logger.info("***********Reading User*********");
		Response response = UserEndPoints.readPet((long) this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		//log
				logger.info("***********Pet is read *********");
	}
	
	@Test(priority=3)
	public void testdeletePet()
	{
		//log
				logger.info("*********** Deleting Pet *********");
				
		Response response = UserEndPoints.deletePet((long) this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		//log
				logger.info("*********** Pet Deleted *********");
	}
}
