package com.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        1) All requests should be authenticated
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
//        2) If a request is not authenticated, a web page is shown
        httpSecurity.httpBasic(Customizer.withDefaults());
//        3) CSRF -> POST, PUT
        // httpSecurity.csrf().disable(); // Deprecated in SB 3.1.x
//        httpSecurity.csrf(csrf -> csrf.disable()); // Starting from SB 3.1.x Using Lambda DSL
        // OR
        httpSecurity.csrf(AbstractHttpConfigurer::disable); // Starting from SB 3.1.x Using Method Reference
        return httpSecurity.build();
    }
}
