package StepDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class End2EndAPI {
private static final String PET_STORE_BASE_URL = "https://petstore.swagger.io";
	private static String apiURL;
	public static ValidatableResponse json;
	public static RequestSpecification request;
	private static Response response;
	private static String jsonString;
	private static List<Map<String, String>> petsList;
	private static long petId;
	private static String orderId = "1";

    @Given("I Set Get Pet By Status API EndPoint {string}")
    public void set_endpoint(String endpoint) {
    	apiURL = endpoint;
		System.out.println("API URL :"+apiURL);
    }

    @When("I search for {string} pets")
    public void set_list_status(String status) throws Exception {
    	apiURL = apiURL + "?status="+status;
    }

    @When("I set the Order Id for Delete")
    public void set_delete_order_id() throws Exception {
    	apiURL = apiURL+"/"+orderId;
    }

    @And("I choose first Pet from the Pet List")
    public void list_all_pets() throws Exception {
    	RestAssured.baseURI = PET_STORE_BASE_URL;
    	End2EndAPI.request = RestAssured.given();
    	End2EndAPI.response = request.get(apiURL);
		Assert.assertEquals(200, response.getStatusCode());
		jsonString = response.asString();
		End2EndAPI.petsList = JsonPath.from(jsonString).get();
		JsonPath jsonPathEvaluator = response.jsonPath();
		ArrayList<Long> listOfIds =  jsonPathEvaluator.get("id");
		petId = listOfIds.get(0);

    }
 

    @When("I {string} order for {int} Pets with request body")
    public void order_pet(String status, int quantity) throws Exception {
    	RestAssured.baseURI = PET_STORE_BASE_URL;
    	End2EndAPI.request = RestAssured.given();
    	End2EndAPI.request.header("Content-Type", "application/json");
    	String requestBody = "{ \"petId\": \"" + petId + "\", " +
    			"\"quantity\": \"" + quantity + "\", " + 
    			"\"status\": \"" + status + "\", " + 
    			"\"complete\": true," + 
    			"\"shipDate\": \"2022-10-11T14:49:04.716Z\""+
    			"}";

    	End2EndAPI.response = End2EndAPI.request.body(requestBody).post(apiURL);
    	JsonPath jsonPathEvaluator = response.jsonPath();
    	long createdOrder = jsonPathEvaluator.get("id");
    	orderId = Long.toString(createdOrder);
    	System.out.println(orderId);
    	// jsonString = response.asString();
    	// System.out.println(orderId);
    }

    @When("Delete the placed Order and Message is same as Order Id")
    public void delete_order() throws Exception {
    	RestAssured.baseURI = PET_STORE_BASE_URL;
    	End2EndAPI.request = RestAssured.given();
    	End2EndAPI.request.header("Content-Type", "application/json");
    	System.out.println("apiURL :" +apiURL);
    	End2EndAPI.response = End2EndAPI.request.delete(apiURL);
    	JsonPath jsonPathEvaluator = response.jsonPath();
    	System.out.println("Response: "+jsonPathEvaluator.get("message"));
    	Assert.assertEquals(orderId, jsonPathEvaluator.get("message"));

    }
   

    @Then("a 200 response is returned")
    public void check_resonse() throws Exception {
   	   Assert.assertEquals(200, End2EndAPI.response.getStatusCode());
    }
}