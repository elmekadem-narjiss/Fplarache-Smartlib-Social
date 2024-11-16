package com.example.servicesocial.Conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**") // Autorise l'accès aux ressources Swagger
                .permitAll()  // Permet l'accès à ces ressources sans authentification
                .anyRequest().authenticated()  // Nécessite une authentification pour toutes les autres URL
                .and();// Ou authentification de base pour les tests

        return http.build();
    }
}
