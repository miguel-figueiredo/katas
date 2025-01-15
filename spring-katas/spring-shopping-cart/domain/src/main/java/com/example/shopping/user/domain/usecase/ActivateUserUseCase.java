package com.example.shopping.user.domain.usecase;

import com.example.shopping.user.domain.model.User;
import com.example.shopping.user.port.in.ActivateUser;
import com.example.shopping.user.port.in.CreateUser;
import com.example.shopping.user.port.out.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class ActivateUserUseCase implements ActivateUser {

    private final UserRepository repository;

    @Inject
    public ActivateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(final String email) {
        repository.setActive(email);
    }
}
