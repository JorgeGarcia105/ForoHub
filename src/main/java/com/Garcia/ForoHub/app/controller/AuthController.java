package com.Garcia.ForoHub.app.controller;

import com.Garcia.ForoHub.application.dtos.DtoAuthenticationUser;
import com.Garcia.ForoHub.domain.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
/*
    @PostMapping
    public ResponseEntity userAuthentication(@RequestBody @Valid DtoAuthenticationUser dtoAuthenticationUser){
        Authentication authToken = new UsernamePasswordAuthenticationToken(
                dtoAuthenticationUser.username(),
                dtoAuthenticationUser.password());
        var userAuthenticated = authenticationManager.authenticate(authToken);
        var JwtToken = tokenService.generateToken((User) userAuthenticated.getPrincipal());
        return ResponseEntity.ok(new DtoAuthenticationToken(JwtToken));
    }*/
}
