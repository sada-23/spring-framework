package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/user")
    public String user(){
        String a = "apple";
        return "/user/userinfo.html"; // In Default Spring looking for a Html static pages under static folder.
    }




}
