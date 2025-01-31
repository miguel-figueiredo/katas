package com.example.shopping.purchase.adapter.in.rest;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartItemsResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CartItemsResource.class);
    }

    @Test
    public void getCartItems() {
        Response response = target("/cart/items")
                .request()
                .get();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));
        assertEquals(List.of(), response.readEntity(List.class));
    }
}