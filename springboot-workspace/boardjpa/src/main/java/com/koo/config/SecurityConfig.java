package com.koo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity	
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests( (authorizeHttpRequest) ->
		authorizeHttpRequest.requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
		.csrf((csrf)-> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/**")))
		.formLogin((formLogin) -> formLogin.loginPage("/user/login")
					.defaultSuccessUrl("/notice/list"));
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
