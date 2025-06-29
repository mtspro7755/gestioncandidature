package com.institut.gestioncandidature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher; // <-- Supprimez cet import si vous ne l'utilisez plus !

@Configuration
// @EnableWebSecurity // Assurez-vous que cette annotation est présente si vous n'avez pas de configuration par défaut ailleurs
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Autoriser les chemins de Swagger UI
                        .requestMatchers(
                                "/swagger-ui/**",          // Chemin pour l'interface UI
                                "/v3/api-docs/**",         // Chemin pour la spécification OpenAPI JSON/YAML
                                "/v2/api-docs/**",         // Pour la compatibilité avec OpenAPI 2 (si vous en aviez besoin)
                                "/swagger-resources/**",   // Pour les ressources de Swagger (compatibilité)
                                "/webjars/**"              // Pour les assets statiques (CSS, JS) de Swagger UI
                        ).permitAll()
                        // Autoriser tous les endpoints sous /api/candidatures (votre API)
                        .requestMatchers(
                                "/api/candidatures/**"
                        ).permitAll()
                        // --- Si vous avez un context-path comme /ipsl, ajoutez-le ici aussi ---
                        // Par exemple :
                        // .requestMatchers("/ipsl/swagger-ui/**", "/ipsl/v3/api-docs/**", "/ipsl/api/candidatures/**").permitAll()
                        // ---------------------------------------------------------------------

                        .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                )
                .csrf(csrf -> csrf.disable()); // Désactiver CSRF pour les APIs REST, à moins que vous ne le gériez explicitement

        return http.build();
    }
}
