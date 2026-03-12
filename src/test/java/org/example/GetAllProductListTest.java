package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.MatcherAssert.assertThat;

public class GetAllProductListTest {
    //private static Response response ;
@Test
@DisplayName("Test for getting all product list")
    public void GetAllProducts() {
     RestAssured
            .given()
            .baseUri("https://automationexercise.com/api")
            .basePath("/productsList")
            .when()
            .get()
            .then()
            .statusCode(200);
}


}
