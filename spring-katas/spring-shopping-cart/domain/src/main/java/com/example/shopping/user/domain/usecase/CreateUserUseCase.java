package com.example.shopping.user.domain.usecase;

import com.example.shopping.user.domain.model.User;
import com.example.shopping.user.port.in.CreateUser;
import com.example.shopping.user.port.out.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class CreateUserUseCase implements CreateUser {

    private final UserRepository repository;

    @Inject
    public CreateUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(final User user) {
        repository.save(user);
    }
}
