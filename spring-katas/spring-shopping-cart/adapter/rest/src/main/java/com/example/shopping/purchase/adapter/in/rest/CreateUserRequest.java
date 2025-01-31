package com.example.shopping.purchase.adapter.in.rest;

import com.example.shopping.user.domain.model.User;

public record CreateUserRequest(
        String email,
        String password
) {

    public User toUser() {
        return new User(email, password, false);
    }
}
