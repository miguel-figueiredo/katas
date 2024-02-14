package com.example.namestore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.UUID;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NameStoreControllerTest {

    @BeforeEach
    void setUp() {
        standaloneSetup(new NameStoreController());
    }

    @Test
    void getNonExisting() {
        given()
        .when()
            .get("http://localhost:8080/names/" + UUID.randomUUID())
        .then()
            .status(HttpStatus.NOT_FOUND);
    }

    @Test
    void deleteNonExisting() {
        given()
        .when()
            .delete("http://localhost:8080/names/" + UUID.randomUUID())
        .then()
            .status(HttpStatus.NOT_FOUND);
    }

    @Test
    void updateNonExisting() {
        given()
            .body("Miguel")
        .when()
            .put("http://localhost:8080/names/" + UUID.randomUUID())
        .then()
            .status(HttpStatus.NOT_FOUND);
    }

    @Test
    void createAndGet() {
        final String uuid = given()
                .body("Miguel")
            .when()
                .post("http://localhost:8080/names")
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        final String name = given()
            .when()
                .get("http://localhost:8080/names/" + uuid)
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        assertEquals("Miguel", name);
    }

    @Test
    void createDeleteAndGet() {
        final String uuid = given()
                .body("Miguel")
            .when()
                .post("http://localhost:8080/names")
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        given()
        .when()
            .delete("http://localhost:8080/names/" + uuid)
        .then()
            .status(HttpStatus.OK);

        given()
        .when()
            .get("http://localhost:8080/names/" + uuid)
        .then()
            .status(HttpStatus.NOT_FOUND);
    }

    @Test
    void createAndUpdatedAndGet() {
        final String uuid = given()
                .body("Miguel")
            .when()
                .post("http://localhost:8080/names")
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        given()
            .body("Pedro")
        .when()
            .put("http://localhost:8080/names/" + uuid)
        .then()
            .status(HttpStatus.OK)
            .extract().body().asString();

        final String name = given()
            .when()
                .get("http://localhost:8080/names/" + uuid)
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        assertEquals("Pedro", name);
    }

    @Test
    void createAndList() {
        final String uuid = given()
                .body("Miguel")
            .when()
                .post("http://localhost:8080/names")
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        final String name = given()
            .when()
                .get("http://localhost:8080/names")
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        assertEquals(uuid + " - Miguel", name);
    }
}