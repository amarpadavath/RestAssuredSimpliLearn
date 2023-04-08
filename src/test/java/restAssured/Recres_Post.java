package restAssured;


import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import reusable.Reusable;

public class Recres_Post {
    //amar-main
    public static Reusable obj;
    public static String my_request_body =  "{\n" +
            "    \"name\": \"amar\",\n" +
            "    \"job\": \"leader\"\n" +
            "}";

    public static void main (String[] args) throws Exception
    {
        obj = new Reusable();


        users_post_call();



    }

    public static void   users_post_call()
    {
        RestAssured.baseURI=obj.ReadPropertiesFile("recresURI1");



        Response res = RestAssured.given().contentType(ContentType.JSON).body(my_request_body).post();

        int status_Code = res.getStatusCode();
        System.out.println("After hitting url, status code is :"+status_Code);

        //Assert.assertEquals( 200, status_Code);



        Assert.assertEquals(Integer.parseInt(obj.ReadPropertiesFile("responseStatus")), status_Code);
        // System.out.println(s);
        String resBody = res.getBody().asString();
        System.out.println("After hitting google url, response body look like"+resBody);


    }




}
