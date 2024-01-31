package com.example.hello;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HelloNameControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    void get() {
        final String response = given()
            .when()
                .get("http://localhost:8080/hello")
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        assertEquals("Hello, world!", response);
    }

    @Test
    void getName() {
        final String response = given()
            .when()
                .get("http://localhost:8080/hello/Miguel")
            .then()
                .status(HttpStatus.OK)
                .extract().body().asString();

        assertEquals("Hello, Miguel!", response);
    }
}