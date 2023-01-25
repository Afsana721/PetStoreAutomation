package api.Endpoints2;

import static io.restassured.RestAssured.*;
/*
for Swagger URI--> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get usre(Get): https://petstore.swagger.io/v2/user/{username}
Update user(Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
*/
public class Routes {
	//user module
	public static String base_url = "https://petstore.swagger.io/v2";		//main domain URL
	public static String post_url =base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url =base_url+"/user/{username}";
	public static String delete_url =base_url+"/user/{username}";
	
	//store module
	//pet module urls we can create if required
	

}
