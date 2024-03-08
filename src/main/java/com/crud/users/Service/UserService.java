package com.crud.users.Service;

import com.crud.users.domain.user.Role;
import com.crud.users.domain.user.User;
import com.crud.users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException(("Cant find user with id " + userId)));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    // Método de búsqueda por email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Método de búsqueda por rol
    public List<User> getUsersByRole(Role role) {
        return userRepository.findByRole(role);
    }
}

