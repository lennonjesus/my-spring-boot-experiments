package com.lennonjesus.experiments.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lennonjesus on 04/09/15.
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String home() {
        return "/user/home";
    }

    @RequestMapping("/403")
    public String unauthorized() {
        return "/errors/403";
    }

}
