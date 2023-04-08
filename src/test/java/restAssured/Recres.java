package restAssured;


import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.Assert;
import reusable.Reusable;

public class Recres  {
//amar-main
    public static Reusable obj;

    public static void main (String[] args) throws Exception
    {
       obj = new Reusable();

       for(int i=2;i<=10;i++)
       {
           validateGoogleUrl(i);
       }


    }

    public static void   validateGoogleUrl(int i)
    {
        RestAssured.baseURI=obj.ReadPropertiesFile("recresURI")+String.valueOf(i);



        Response res = RestAssured.get();

        int status_Code = res.getStatusCode();
        System.out.println("After hitting url, status code is :"+status_Code);

        //Assert.assertEquals( 200, status_Code);



        Assert.assertEquals(Integer.parseInt(obj.ReadPropertiesFile("responseStatus")), status_Code);
        // System.out.println(s);
        String resBody = res.getBody().asString();
        System.out.println("After hitting google url, response body look like"+resBody);


    }




}
