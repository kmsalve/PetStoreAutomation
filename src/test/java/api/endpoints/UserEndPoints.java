package api.endpoints;


import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//User model end points
//CRUD request operations to User Api
public class UserEndPoints {

	
	public static Response createUser(User payload)
	{
		Response res = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return res;
	}

	public static Response readUser(String userName)
	{
		Response res = 
		given()
			.pathParam("username", userName)
		
		.when()
			.get(Routes.get_url);
	
		return res;
	}
	
	public static Response updateUSer(String userName, User payload)
	{
		Response res = 
		given()
			.pathParam("username", userName)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.put(Routes.put_url);
	
		return res;
	}
	
	public static Response deleteUSer(String userName)
	{
		Response res = 
		given()
			.pathParam("username", userName)
		
		.when()
			.delete(Routes.delete_url);
	
		return res;
	}
}
