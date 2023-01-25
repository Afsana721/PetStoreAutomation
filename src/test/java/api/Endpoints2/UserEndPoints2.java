package api.Endpoints2;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.Payload2.User;

//UserEndpoint.java file, for perform Create, Read, Update & Delete request on the User API.


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {

// method created for getting URL's from properties file
	public static ResourceBundle  getURL() 
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");  		//Load properties file.
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		String post_url =getURL().getString("post_url");
		Response response =given()
											.contentType(ContentType.JSON)
											.accept(ContentType.JSON)
											.body(payload)
										.when()
											.post(post_url );
						return response;
		}
	
	public static Response getUser(String userName) {
		
		String get_url =getURL().getString("get_url");
		
		Response response =given()
										.pathParam("username", userName)										
									.when()
										.get(get_url);
					return response;
	}
	
	public static Response updateUser( String userName, User payload) {
		
		String update_url =getURL().getString("update_url");
		
		Response response =given()
											.contentType(ContentType.JSON)
											.accept(ContentType.JSON)
											.pathParam("username", userName)
											.body(payload)
											
										.when()
											.put(update_url);
						return response;
		}
	
	public static Response DeleteUser(String userName) {
		
		String delete_url =getURL().getString("delete_url");
		
		Response response =given()
										.pathParam("username", userName)										
									.when()
										.delete(delete_url);
					return response;
	}
}
