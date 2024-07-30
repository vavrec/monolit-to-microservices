package cz.vavrecka.monolittomicroservices.user.service;


import cz.vavrecka.monolittomicroservices.user.domain.User;
import cz.vavrecka.monolittomicroservices.user.dto.NewUserDto;
import cz.vavrecka.monolittomicroservices.user.exception.UserDoesNotExistsException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    // TMP solution - az pripojim DB, tak zmenit
    private final Map<UUID, User> users = new ConcurrentHashMap<>();


    public User createUser(NewUserDto newUserDto) {
        User user = new User(UUID.randomUUID(), newUserDto.firstName(), newUserDto.lastName(), newUserDto.email());
        users.put(user.id(), user);
        return user;
    }

    public User updateUser(User user) {
        if (users.containsKey(user.id())) {
            users.put(user.id(), user);
            return user;
        } else {
            throw new UserDoesNotExistsException("User with id " + user.id() + " does not exist");
        }
    }

    public Optional<User> getUserById(UUID id) {
        return Optional.of(users.get(id));
    }

    // TODO tady pridat Pagination
    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }

    public void deleteUserById(UUID id) {
            users.remove(id);
    }

}
