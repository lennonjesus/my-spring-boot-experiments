package com.lennonjesus.experiments.authentication.service;

import com.lennonjesus.experiments.authentication.domain.User;
import com.lennonjesus.experiments.authentication.form.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

/**
 * @author Lennon Jesus
 */
public interface UserService {

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
