package api.endpoints;

//maintain URI from swagger petstore

//Post - https://petstore.swagger.io/v2/user
//Get -Https://petstore.swagger.io/v2/user/{username}
//Put - Https://petstore.swagger.io/v2/user/{username}
//Delete - Https://petstore.swagger.io/v2/user/{username}

//Base url - Https://petstore.swagger.io/v2

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	// User model end points
	
	public static String post_url = base_url +"/user";
	public static String get_url = base_url +"/user/{username}";
	public static String put_url = base_url +"/user/{username}";
	public static String delete_url = base_url +"/user/{username}";
	
	
	//Pet Model urls
	public static String pet_post_url = base_url +"/pet";
	public static String pet_get_url = base_url +"/pet/{petId}";
	public static String pet_put_url = base_url +"/pet/{petId}";
	public static String pet_delete_url = base_url +"/pet/{petId}";
	
	
	// Store model urls
	
	public static String order_post_url = base_url +"/store/order";
	public static String order_get_url = base_url +"/store/order/{orderId}";
	public static String order_delete_url = base_url +"/store/order/{orderId}";
}



