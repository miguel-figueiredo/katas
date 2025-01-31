package com.example.shopping.purchase.adapter.in.rest;

import com.example.shopping.purchase.domain.model.Item;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Path("/cart/items")
public class CartItemsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> list() {
        log.info("Listing cart items: {}", "TODO");
        // TODO: implement
        return List.of();
    }
}
