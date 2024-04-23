package api.endpoints;

import api.payload.*;


import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//User model end points
//CRUD request operations to User Api
public class UserEndPoints {

	
	//User model requests - CRUD
	
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
	
	//Pet Model requests
	public static Response createPet(Pet payload)
	{
		Response res = 
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.pet_post_url);
		
		return res;
	}
	
	public static Response readPet(long petId)
	{
		Response res = 
		given()
			.pathParam("petId", petId)
		
		.when()
			.get(Routes.pet_get_url);
	
		return res;
	}
	
	public static Response updatePet(String petId, Pet payload)
	{
		Response res = 
		given()
			.pathParam("petId", petId)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.post(Routes.pet_put_url);
	
		return res;
	}
	
	public static Response deletePet(long petId)
	{
		Response res = 
		given()
			.pathParam("petId", petId)
		
		.when()
			.delete(Routes.pet_delete_url);
	
		return res;
	}
	
	//order requests
	
	//Pet Model requests
		public static Response createOrder(Order payload)
		{
			Response res = 
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			
			.when()
				.post(Routes.order_post_url);
			
			return res;
		}
		
		public static Response readOrder(int orderId)
		{
			Response res = 
			given()
				.pathParam("orderId", orderId)
			
			.when()
				.get(Routes.order_get_url);
		
			return res;
		}
		
		public static Response deleteOrder(int orderId)
		{
			Response res = 
			given()
				.pathParam("orderId", orderId)
			
			.when()
				.delete(Routes.order_delete_url);
		
			return res;
		}
}
