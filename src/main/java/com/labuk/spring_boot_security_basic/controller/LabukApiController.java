package com.labuk.spring_boot_security_basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/labuk")
public class LabukApiController {

    @GetMapping("/security")
    public String getSecurity(){
        return "example";
    }
}
