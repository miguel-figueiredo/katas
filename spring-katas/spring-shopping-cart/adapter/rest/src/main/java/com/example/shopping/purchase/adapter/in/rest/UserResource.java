package com.example.shopping.purchase.adapter.in.rest;

import com.example.shopping.user.port.in.ActivateUser;
import com.example.shopping.user.port.in.CreateUser;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/users")
public class UserResource {

    private final CreateUser createUser;
    private final ActivateUser activateUser;

    @Inject
    public UserResource(
            CreateUser createUser,
            ActivateUser activateUser) {
        this.createUser = createUser;
        this.activateUser = activateUser;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createUser(CreateUserRequest request) {
        log.info("Creating user: {}", request.toUser());
        createUser.execute(request.toUser());
    }

    @PUT
    @Path("/{email}:activate")
    public void activateUser(@PathParam("email") String email) {
        log.info("Activating user: {}", email);
        activateUser.execute(email);
    }
}
