package cz.vavrecka.monolittomicroservices.user.service;


import cz.vavrecka.monolittomicroservices.user.domain.User;
import cz.vavrecka.monolittomicroservices.user.dto.NewUserDto;
import cz.vavrecka.monolittomicroservices.user.repository.UserRepository;
import cz.vavrecka.shared.exception.ObjectDoesNotExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(NewUserDto newUserDto) {
        User user = new User(null, newUserDto.firstName(), newUserDto.lastName(), newUserDto.email());
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        userRepository.findById(user.id()).
        orElseThrow(() -> new ObjectDoesNotExistsException("User with id " + user.id() + " does not exist"));
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // TODO tady pridat Pagination
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public void deleteUserById(Long id) {
          userRepository.deleteById(id);
    }
}
