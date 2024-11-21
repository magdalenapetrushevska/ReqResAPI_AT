import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class APITests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    // GET all resources
    @Test
    public void getAllResources() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/resource")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    // GET all users
    @Test
    public void getAllUsers() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    // GET resources by page number
    @Test
    public void getResourcesByPageNumber() {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("page",1)
                .when()
                .get("/resource")

                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    // GET resources by page number
    @Test
    public void getResourceById() {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("id",1)
                .when()
                .get("/resource")

                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    // GET user by id
    @Test
    public void getUserById() {
        Response response = given()
                .contentType(ContentType.JSON)
                .queryParam("id",1)
                .when()
                .get("/users")

                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }






}
