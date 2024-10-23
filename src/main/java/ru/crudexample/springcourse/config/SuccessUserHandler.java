package ru.crudexample.springcourse.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.crudexample.springcourse.models.User;

import java.io.IOException;
import java.util.Set;

@Component
public class SuccessUserHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

//        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        User user = (User) authentication.getPrincipal();

        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        response.sendRedirect("/index");
    }
}