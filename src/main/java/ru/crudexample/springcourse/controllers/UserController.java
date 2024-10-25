package ru.crudexample.springcourse.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.crudexample.springcourse.models.Role;
import ru.crudexample.springcourse.models.User;
import ru.crudexample.springcourse.service.UserService;
import ru.crudexample.springcourse.service.UserServiceImpl;

import java.util.*;

@Controller
@Slf4j
public class UserController {

    @GetMapping("/index")
    public String index(Model model, HttpSession session) {
        log.info("Start page - 5.1.5");
        log.info("Start page - 5.1.5. Liquibase was added");
        model.addAttribute("user", session.getAttribute("user"));
        return "index";
    }


}
