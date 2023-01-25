package api.Test2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.Endpoints2.UserEndPoints;
import api.Payload2.User;
import io.restassured.response.Response;


public class UserTests {
	
	public Faker faker;
	public User userPayload;
	public Logger logger;

	
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().lastName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
// initiate logs
	logger =LogManager.getLogger(this.getClass());
		
	}
	@Test(priority =1)
	public void testPostUser() {
		
		logger.info("************* Creating user **********************");
		Response response =UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* User is created **********************"); 		
	}
	
	@Test(priority =2)
	public void testGetUserByName() {
		
		logger.info("************* Reading User Info  **********************");
		
		Response response =UserEndPoints.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		
		logger.info("************* User Info is desplayed  **********************");
				
	}
	
	@Test(priority=3)
	public void updataeUserByName() {
	
		logger.info("************* Updating User  **********************");
		
	//update data using same payload.
		userPayload.setFirstName(faker.name().lastName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response =UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* User upddated **********************");
		
	// checking data after updated
		
		Response responseAfterupdate =UserEndPoints.getUser(this.userPayload.getUsername());
		 responseAfterupdate.then().log().all();
		Assert.assertEquals( responseAfterupdate.statusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		
		logger.info("************* Deleting User  **********************");
		
		Response response =UserEndPoints.DeleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* User deleted  **********************");
		
	}

}
