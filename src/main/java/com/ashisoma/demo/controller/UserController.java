package com.ashisoma.demo.controller;

import com.ashisoma.demo.model.Model;
import com.ashisoma.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","?index"})
public class UserController {

    // TODO: 18/10/2021 get the full docmunetation
    @GetMapping
    public String getBithDate(Model model){
        model.addAttribute("user", new User());
        return  "index";
    }

    @PostMapping
    public String save(User user, Model model){
        model.addAttribute("user", new User());
        return  "index";
    }
}
