package com.example.shopping.user.port.out;

import com.example.shopping.user.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);

    void setActive(String email);

    Optional<User> findUser(String mail);
}
