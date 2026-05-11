package api.endpoints;

/*
 * Swagger urI---->https://petstore.swagger.io
 * Create user(post)--->https://petstore.swagger.io/v2/user

 * Get user(GET)--->https://petstore.swagger.io/v2/user/{username}

 * UpdateUser(PUT)--->https://petstore.swagger.io/v2/user/{username}

 * Delete User(Delete)--->https://petstore.swagger.io/v2/user/{username}
 * 
 */

public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	//User module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//Store module
	public static String storePost_url=base_url+"/store/order";
	public static String storeGet_url=base_url+"/store/order/{orderId}";
	public static String storeDelete_url=base_url+"/store/order/{orderId}";
	public static String storeGetAllInventory_url=base_url+"/store/inventory";
	
	//Pet Module
		//In future here u will write Pet module URL
}
