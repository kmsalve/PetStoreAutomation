package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	
	@Test(priority=1, dataProvider="Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph) 
	{	
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setFirstname(fname);
		userPayload.setLastname(lname);
		userPayload.setEmail(useremail);
		userPayload.setUsername(userName);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response res = UserEndPoints.createUser(userPayload);
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass = DataProviders.class)
	public void deleteUserbyName(String userName) 
	{
		Response res = UserEndPoints.deleteUSer(userName);
		
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
	}
	
	
}
