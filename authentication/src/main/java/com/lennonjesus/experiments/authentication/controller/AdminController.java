package com.lennonjesus.experiments.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lennonjesus on 03/09/15.
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String home() {
        return "/admin/home";
    }

}
