package restAssured;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.Assert;
import reusable.Reusable;

public class GoogleTest  extends Reusable {

    public static void main (String[] args) throws Exception
    {
        GoogleTest s = new GoogleTest();
        s.validateGoogleUrl();

        validateGoogleUrl1();


    }

    public void   validateGoogleUrl()
    {
        RestAssured.baseURI=ReadPropertiesFile("baseURI");



        Response res = RestAssured.get();

        int status_Code = res.getStatusCode();
         System.out.println("After hitting url, status code is :"+status_Code);

      //Assert.assertEquals( 200, status_Code);

        Assert.assertEquals(Integer.parseInt(ReadPropertiesFile("responseStatus")), status_Code);
       // System.out.println(s);
        String resBody = res.getBody().asString();
        System.out.println("After hitting google url, response body look like"+resBody);


    }

    public static void   validateGoogleUrl1()
    {
        RestAssured.baseURI="https://www.google.com";
      RestAssured.given().when().get().then().statusCode(200);
    }



}
