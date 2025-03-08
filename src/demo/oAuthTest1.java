package demo;
import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;


public class oAuthTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String accessTokenResponse = given().
		queryParams("code","")
		.queryParams( "client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("accessToken");
		
		
		
		
		String response = given().queryParam("access_token",accessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
		
		
		
		

	}

}
