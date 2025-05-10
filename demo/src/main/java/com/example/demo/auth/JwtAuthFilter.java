package com.example.demo.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import lombok.RequiredArgsConstructor;

/**
 * Filter that checks for a JWT in the Authorization header,
 * validates it, and sets authentication in the security context.
 */
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
                                    throws ServletException, IOException {
        // Get the Authorization header and check for Bearer token
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extract the token (remove "Bearer " prefix)
        jwt = authHeader.substring(7);
        // Use the existing JwtUtils method
        username = jwtUtils.getUserNameFromJwtToken(jwt);

        // Only set authentication if user is not already authenticated
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Load user details from your user repository
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Validate the token (no second arg needed, we just call validateJwtToken(jwt))
            if (jwtUtils.validateJwtToken(jwt)) {
                // Create and set authentication
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Proceed with the filter chain
        filterChain.doFilter(request, response);
    }
}
