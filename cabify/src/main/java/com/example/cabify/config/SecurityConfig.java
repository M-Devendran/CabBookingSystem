package com.example.cabify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF (Cross-Site Request Forgery)
                .csrf(csrf -> csrf.disable())

                // 2. Configure which URLs are public and which are private
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("**/register", "/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )

                // 3. Allow H2 Console to display inside a browser frame
                .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}
