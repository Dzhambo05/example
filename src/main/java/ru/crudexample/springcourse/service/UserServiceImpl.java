package ru.crudexample.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.crudexample.springcourse.dao.UserRepository;
import ru.crudexample.springcourse.models.Role;
import ru.crudexample.springcourse.models.User;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.getById(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    @Transactional
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    @Transactional
    public void deleteUserById(UUID id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public User updateUserByEmail(String email, Integer updateAge, String updateName, String updateEmail) {
        User user = userRepository.getByEmail(email);
        user.setAge(updateAge);
        user.setName(updateName);
        user.setEmail(updateEmail);
        userRepository.save(user);
        return user;
    }

//    @Override
//    @Transactional
//    public void updateToAdmin(String login) {
//        userRepository.getUserByLogin(login).getRoles().add(new Role("ROLE_ADMIN"));
//    }
//
//    @Override
//    @Transactional
//    public void cancelAdminRole(String login) {
//        userRepository.getUserByLogin(login).getRoles().removeIf(x -> x.getRole().equals("ROLE_ADMIN"));
//    }
}
