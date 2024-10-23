package ru.crudexample.springcourse.service;

import org.springframework.stereotype.Service;
import ru.crudexample.springcourse.models.User;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public User addUser(User user);
    public User getUserByEmail(String email);
    public User getUserByLogin(String login);
    public User getUserById(UUID id);
    public void deleteUserByEmail(String email);
    public void deleteUserById(UUID id);
    public User updateUserByEmail(String email, Integer updateAge, String updateName, String updateEmail);

//    void updateToAdmin(String login);
//    void cancelAdminRole(String login);
}
