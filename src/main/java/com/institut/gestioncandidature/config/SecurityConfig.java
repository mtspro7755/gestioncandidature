// src/main/java/com/institut/gestioncandidature/config/SecurityConfig.java

package com.institut.gestioncandidature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // <-- Assurez-vous d'avoir cette annotation

@Configuration
@EnableWebSecurity // Active la configuration de sécurité web de Spring
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactive CSRF pour les API REST (important pour POST, PUT, DELETE)
                .authorizeHttpRequests(authorize -> authorize
                        // Autoriser tous les endpoints sous /api/candidatures
                        .requestMatchers("/api/candidatures/**").permitAll()
                        // Autoriser tous les endpoints sous /api/filieres (votre nouveau endpoint)
                        .requestMatchers("/api/filieres/**").permitAll()
                        // Autoriser tous les endpoints sous /api/candidats/ (votre nouveau endpoint)
                        .requestMatchers("/api/candidats/**").permitAll()
                        // Autoriser les chemins de Swagger UI
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/v2/api-docs/**",
                                "/swagger-resources/**",
                                "/webjars/**"
                        ).permitAll()
                        // Autoriser les requêtes POST vers /error qui sont déclenchées par des erreurs
                        .requestMatchers("/error").permitAll() // Le filtre a tenté de sécuriser /error aussi
                        .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                );
        // Si vous avez un mécanisme de connexion/déconnexion, vous pouvez le configurer ici
        // .formLogin(Customizer.withDefaults()) // Active la page de login par défaut de Spring Security
        // .httpBasic(Customizer.withDefaults()); // Active l'authentification HTTP Basic

        return http.build();
    }
}
