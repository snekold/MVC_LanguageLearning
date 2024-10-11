package org.example.mvc_languagelearning.controller;

import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.mvc_languagelearning.UserRepository;
import org.example.mvc_languagelearning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor

public class UserController {
    private final UserRepository userRepository;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
    @GetMapping(value="/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    //localhost:8080/registration?login=jon&password=123&repetitionPassword=123
    public String registrationPost(
           @RequestParam(required = true) String login,
           @RequestParam String password,
           @RequestParam String repetitionpassword) {

        if (!password.equals(repetitionpassword)) {
            try {
                throw new RuntimeException("Passwords do not match " + repetitionpassword + ":"+password ) ;
            }catch (Exception e) {
                log.error(e.getMessage());
            }

           return "registration";
        }

        User user = new User();
        user.setUsername(login);
        user.setPassword(password);
        user.setPoint(0);

        userRepository.save(user);
        return "lk";
    }


}
