package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PostAllProductListTest {
private static Response response;
    @BeforeAll
    public static void setup(){
    response =  RestAssured
                .given()
                //.baseUri(
                .when()
                .post("https://automationexercise.com/api/productsList")
                .thenReturn();
                //.statusCode(200);
        //.body("message", equalTo("<{responseCode: 405, message: This request method is not supported.}>"));
    }
   @Test
    @DisplayName("Test the error code ")
    public void errorCodeTest(){
        MatcherAssert.assertThat(response.getBody().asString(), Matchers.containsString("405"));
    }

//        @Test
//    @DisplayName("Test the error code ")
//    public void dummy(){
//        MatcherAssert.assertThat(true, is(true));
//    }

}
