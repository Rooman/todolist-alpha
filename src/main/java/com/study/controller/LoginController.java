package com.study.controller;

import com.study.dao.SecurityService;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    SecurityService securityService;

    public void login(String name, String password) {
        //    securityService.loginAndSaveSession(name, password);
    }
}
