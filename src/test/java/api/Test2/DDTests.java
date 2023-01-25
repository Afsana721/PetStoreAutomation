package api.Test2;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.Endpoints2.UserEndPoints;
import api.Payload2.User;
import io.restassured.response.Response;
import api.utilities.DataProviderClass;
public class DDTests {
	
	
	@Test(priority =1, dataProvider ="Data", dataProviderClass=DataProviderClass.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd, String ph) {
		
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response =UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		 		
	}

	@Test(priority =2, dataProvider = "UserNames", dataProviderClass = DataProviderClass.class)
	public void testDeleteUserByName(String userName) {
		
			Response response =UserEndPoints.DeleteUser(userName);
			Assert.assertEquals(response.getStatusCode(), 200);
			
	}
	
	
	
	
	
}
