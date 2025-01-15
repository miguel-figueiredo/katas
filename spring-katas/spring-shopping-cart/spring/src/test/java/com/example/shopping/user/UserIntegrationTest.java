package com.example.shopping.user;

import com.example.shopping.user.adapter.in.rest.CreateUserRequest;
import com.example.shopping.user.domain.model.User;
import com.example.shopping.user.port.out.UserRepository;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserIntegrationTest {

    public static final String EMAIL = "miguel@kn.com";
    public static final String PASSWORD = "password";
    public static final User INACTIVE_USER = new User(EMAIL, PASSWORD, false);
    public static final User ACTIVE_USER = new User(EMAIL, PASSWORD, true);
    @LocalServerPort
    private int port;

    @Inject
    UserRepository userRepository;

    @Test
    void createUser() {
        given()
            .port(port)
            .body(new CreateUserRequest(EMAIL, PASSWORD))
            .contentType(ContentType.JSON)
        .when()
            .post("/users")
        .then()
            .statusCode(204);

        final Optional<User> user = userRepository.findUser(EMAIL);

        assertThat(user,
                equalTo(Optional.of(INACTIVE_USER)));
    }

    @Test
    void activateUser() {
        userRepository.save(INACTIVE_USER);

        given()
            .port(port)
            .pathParams("email", EMAIL)
            .urlEncodingEnabled(false)
        .when()
            .put("/users/{email}:activate")
        .then()
            .statusCode(204);

        final Optional<User> user = userRepository.findUser(EMAIL);

        assertThat(user,
                equalTo(Optional.of(ACTIVE_USER)));
    }

}
