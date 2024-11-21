/*
 ******************************************************************************************************************************************
 * Description: This file contains script for testing different test cases related to ReqRes endpoints
 * Author: Magdalena Petrushevska
 * Created_at: 19.11.2024
 * Updated_at:
 * Updated by:
 */


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

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

    // GET resources by id
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

    //POST login method
    @Test
    public void loginToken() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"george.bluth@reqres.in\", \"email\": \"george.bluth@reqres.in\",\"password\": \"test123\"}")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }






}
