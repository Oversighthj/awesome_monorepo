package com.example.demo.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * A stub UserDetailsService that provides a hard-coded in-memory user.
 * This helps satisfy Spring Security requirements for tests.
 */
@Component
public class StubUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Return a fixed user for any username input.
        return User.withUsername("testuser")
                   .password("{noop}password")   // {noop} indicates plaintext password (no encoding).
                   .roles("USER")               // Assigns role ROLE_USER to this user.
                   .build();
    }
}
