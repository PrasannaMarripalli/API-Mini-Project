package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class UserDetailsFromEmailTest {
    private Response response;

    @BeforeEach
    @DisplayName("Retrieve user details")
    public void setUp() {
        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com")
                .basePath("/api/getUserDetailByEmail")
                .queryParam("email", "seb@test.com")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    @DisplayName("Correct postcode returned in result")
    public void testPostcode() {
        assertThat(response.jsonPath().getString("user.first_name"), Matchers.is("Seb"));
        assertThat(response.jsonPath().getString("user.last_name"), Matchers.is("Jennings"));
        assertThat(response.jsonPath().getString("user.address1"), Matchers.is("1 Main street"));
        assertThat(response.jsonPath().getString("user.country"), Matchers.is("United States"));
    }
}