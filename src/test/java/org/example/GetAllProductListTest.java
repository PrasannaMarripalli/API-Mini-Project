package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class GetAllProductListTest {
    private static Response response ;
@Test
@DisplayName("Test for getting all product list")
    public void setUp(){
    RestAssured
            .given()
            .baseUri("https://automationexercise.com/api/productsList")
            .when()
            .get()
            .then()
            .statusCode(200);
}
//@Test
//    @DisplayName("Verify the status code")
//    public void StatusCodeTest(){
//    MatcherAssert.assertThat(response.statusCode(), Matchers.is("200"));
//}

}
