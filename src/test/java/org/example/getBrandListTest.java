package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class getBrandListTest {
    private Response response;

    @BeforeEach
    @DisplayName("ResponseCode received")
    public void setUp() {
        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com")
                .basePath("/api/brandsList")
//                .queryParam("email", "seb@test.com")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    @DisplayName("Correct Brand returned in result")
    public void testBrandPolo() {
        assertThat(response.jsonPath().getString("brands[0].brand"), Matchers.is("Polo"));
    }

    @Test
    @DisplayName("Correct Brand returned in result")
    public void testBrandHnM() {
        assertThat(response.jsonPath().getString("brands[1].brand"), Matchers.is("H&M"));
    }

    @Test
    @DisplayName("Correct Brand returned in result")
    public void testBrandMadame() {
        assertThat(response.jsonPath().getString("brands[2].brand"), Matchers.is("Madame"));
    }

    @Test
    @DisplayName("Correct Brand returned in result")
    public void testBrandASJ() {
        assertThat(response.jsonPath().getString("brands[10].brand"), Matchers.is("Allen Solly Junior"));
    }

    @Test
    @DisplayName("Correct Brand returned in result")
    public void testBrandMnH() {
        assertThat(response.jsonPath().getString("brands[4].brand"), Matchers.is("Mast & Harbour"));
    }
}