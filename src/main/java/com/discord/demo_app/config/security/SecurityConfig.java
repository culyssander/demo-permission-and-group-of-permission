package com.discord.demo_app.config.security;

import com.discord.demo_app.filters.JWTFilter;
import com.discord.demo_app.filters.SecurityFilter;
import com.discord.demo_app.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    private JWTFilter authFilter;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }


        @Autowired
        private SecurityFilter securityFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                    .csrf(csrf -> csrf.disable())
                    .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(req -> {
                        req.requestMatchers(HttpMethod.POST, "/api/v1/login").permitAll();
//                        req.anyRequest().authenticated();
                        req.anyRequest().permitAll();
                    })
                    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                    .build();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception{
            return configuration.getAuthenticationManager();
        }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> cors.configurationSource(request -> {
//                    CorsConfiguration configuration = new CorsConfiguration();
//                    configuration.setAllowedOrigins(Arrays.asList("*"));
//                    configuration.setAllowedMethods(Arrays.asList("*"));
//                    configuration.setAllowedHeaders(Arrays.asList("*"));
//                    return configuration;
//                }))
//                .authorizeHttpRequests(auth -> {
//                    auth
//                            .requestMatchers(HttpMethod.GET, "/").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
//                            .requestMatchers(HttpMethod.POST, "/api/v1/sign").permitAll()
//                            .requestMatchers(HttpMethod.POST, "/api/v1/users/**").authenticated()
//                            .requestMatchers(HttpMethod.GET, "/api/v1/users-logged").authenticated();
//                })
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider())
////                 .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return new ProviderManager(Collections.singletonList(authenticationProvider()));
//    }

}