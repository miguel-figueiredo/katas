package com.example.shopping.user.domain.model;

import lombok.With;

public record User(
        String email,
        String password,
        @With
        boolean active
) {

}
