package com.labuk.spring_boot_security_basic.controller;

import com.labuk.spring_boot_security_basic.dto.LabukAuthRequest;
import com.labuk.spring_boot_security_basic.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/labuk")
public class LabukApiController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/security")
    public String getSecurity() {
        return "Inside Labuk API's";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody LabukAuthRequest labukAuthRequest) throws Exception {
        try {
            authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(labukAuthRequest.getUserName(),
                    labukAuthRequest.getPassword()));
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(labukAuthRequest.getUserName());
    }
}
