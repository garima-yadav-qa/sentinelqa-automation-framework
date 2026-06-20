package com.sentinelqa.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

/** API-layer checks for the billing / subscription service. */
public class BillingApiTest {

    private static final String TOKEN = System.getProperty("apiToken", "test-token");
    private static final String BASE = System.getProperty("apiBase", "https://api.example.test");

    @Test(groups = "api")
    public void upgradeReturnsCreatedAndMatchesSchema() {
        String body = "{ \"plan\": \"pro\", \"customerId\": \"C-1001\" }";

        given()
            .baseUri(BASE)
            .auth().oauth2(TOKEN)
            .contentType("application/json")
            .body(body)
        .when()
            .post("/v1/subscriptions")
        .then()
            .statusCode(201)
            .body("plan", equalTo("pro"))
            .body(matchesJsonSchemaInClasspath("schemas/subscription-schema.json"));
    }
}
