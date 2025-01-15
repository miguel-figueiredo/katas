package com.example.shopping.user.adapter.out.persistence;

import com.example.shopping.user.domain.model.User;
import com.example.shopping.user.port.out.UserRepository;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Named
@Slf4j
public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.email(), user);
    }

    @Override
    public void setActive(final String email) {
        users.computeIfPresent(email, (key, user) ->
            user.withActive(true)
        );
    }

    @Override
    public Optional<User> findUser(final String mail) {
        return Optional.ofNullable(users.get(mail));
    }
}
