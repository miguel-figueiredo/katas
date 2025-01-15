package com.example.shopping.user.port.in;

import com.example.shopping.user.domain.model.User;

public interface CreateUser {
    void execute(User user);
}
