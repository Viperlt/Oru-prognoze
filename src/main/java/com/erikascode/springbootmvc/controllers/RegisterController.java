package com.erikascode.springbootmvc.controllers;

import com.erikascode.springbootmvc.models.User;
import com.erikascode.springbootmvc.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView registrationPage(){

        var modelAndView = new ModelAndView("registration");

        return modelAndView;
    }

    @PostMapping("/register")
    public void registerUser(HttpServletRequest request){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

    }
}
