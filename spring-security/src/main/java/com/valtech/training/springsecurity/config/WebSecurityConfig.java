package com.valtech.training.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception	{
		// write all config and then call build...
		security.cors(cors -> cors.disable());
		security.csrf(csrf -> csrf.disable());
		security.formLogin(formLogin -> formLogin
				.loginPage("/login")
				.defaultSuccessUrl("/user")
				.failureForwardUrl("/login"));
		security.authorizeHttpRequests(requests ->
			requests
			.requestMatchers("/hello","/login","/logout","/register","/jsps/**").permitAll()
			.requestMatchers("/changePassword").authenticated()
//			.requestMatchers("/jsps/changepassword.jsp").hasAnyAuthority("USER")
			.requestMatchers("/admin").hasAnyAuthority("ADMIN")
//			.dispatcherTypeMatchers(DispatcherType.FORWARD,DispatcherType.ERROR).permitAll()
			.anyRequest().authenticated()
//			.anyRequest().permitAll()
		);
		return security.build();
	}
	
//	@Bean
//	public UserDetailsManager userDetailsManager()	{
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.builder().username("scott").password("tiger").roles("USER").build());
//		manager.createUser(User.builder().username("admin").password("admin").roles("USER","ADMIN").build());
//		return manager;
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder()	{
		return new BCryptPasswordEncoder();
//		return NoOpPasswordEncoder.getInstance();
	}
}
