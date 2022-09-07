package com.erpaudit.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-dashboard")
public class UserReportsController {

    @GetMapping
    public String getUserDashboard(){
        return "User-Dashboard";
    }
}
