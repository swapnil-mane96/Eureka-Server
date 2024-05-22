package com.photoapp.discovery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		//httpSecurity.csrf(csrf -> csrf.disable());
		//httpSecurity.csrf().ignoringAntMatchers("/eureka/**");
		//httpSecurity.csrf((csrf) -> csrf.ignoringRequestMatchers("/eureka/**"));
		httpSecurity.csrf((csrf) -> csrf.disable());
		httpSecurity.authorizeHttpRequests((request) -> request.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
		
	}
	
	
}
