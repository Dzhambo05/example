package ru.crudexample.springcourse.controllers;


import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.crudexample.springcourse.models.Role;
import ru.crudexample.springcourse.models.User;
import ru.crudexample.springcourse.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@Slf4j
public class UserRestController {

    private final UserService userService;
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rest/allUsers")
    public List<User> allUsers() {
        log.info("Get all users");
        return userService.getAllUsers();
    }

    @GetMapping("/rest/getUser")
    public User getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user;
    }

    @PostMapping("/rest/add")
    public User addPostUser(User user) {
        log.info("Add new user");
        return userService.addUser(user);
    }
    @GetMapping("/rest/addAdmin")
    @ResponseBody
    public User addPostAdmin(User admin) {
        log.info("Add admin");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ADMIN"));
        admin.setName("admin");
        admin.setAge(1);
        admin.setEmail("admin@gmail.com");
        admin.setLogin("admin");
        admin.setPassword("1");
        admin.setRoles(roles);
        return userService.addUser(admin);
    }

    @GetMapping("/rest/get/{login}")
    public User getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @GetMapping("/rest/find/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping("/rest/update")
    public User updateUser(User user) {
        log.info("User update");
        return userService.addUser(user);
    }

    @PostMapping("/rest/delete")
    public void deleteUser(@RequestParam UUID id) {
        log.info("User delete");
        userService.deleteUserById(id);
    }

}