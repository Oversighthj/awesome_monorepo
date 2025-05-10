package com.example.demo.auth;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
  @Autowired private AuthenticationManager authenticationManager;
  @Autowired private JwtUtils jwtUtils;

  public LoginResponse login(LoginRequest loginRequest) {
    // Perform authentication
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Generate JWT token for the authenticated user
    String jwt = jwtUtils.generateJwtToken(authentication);

    // Get user details to retrieve username and roles
    org.springframework.security.core.userdetails.UserDetails userDetails =
        (org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal();
    List<String> roles =
        userDetails.getAuthorities().stream().map(authority -> authority.getAuthority()).toList();

    // Return a response containing the JWT and user information
    return new LoginResponse(jwt, userDetails.getUsername(), roles);
  }
}
