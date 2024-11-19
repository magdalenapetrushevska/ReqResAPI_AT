import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests {

    @Test
    void getResourceList(){
        Response response = given().get("https://reqres.in/api/resource");
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
