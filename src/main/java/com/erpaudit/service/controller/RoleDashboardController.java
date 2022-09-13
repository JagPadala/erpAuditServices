package com.erpaudit.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role-dashboard")
public class RoleDashboardController {

    @GetMapping
    public String getRoleDashboard(){
        return "Role-Dashboard";
    }
}
