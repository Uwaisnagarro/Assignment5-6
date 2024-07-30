
package com.nagarro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;


	/*@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}*/

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/manage-books", "/add", "/edit").authenticated()
						.anyRequest().permitAll()
				)
				.formLogin(form -> form
						.defaultSuccessUrl("/manage-books")
				)
				.logout(logout -> logout
						.logoutSuccessUrl("/login")
						.permitAll()
				);
		return http.build();
	}

	/*@Bean
	public AuthenticationManagerBuilder authenticationManagerBuilder(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		return auth;
	}*/
}

/*
package com.nagarro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	*/
/*@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}*//*


	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/manage-books", "/add", "/edit").authenticated()
			.anyRequest().permitAll()
			.and()
				.formLogin()
					.defaultSuccessUrl("/manage-books")
			.and()
			.logout().logoutSuccessUrl("/login").permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 //auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
		//auth.userDetailsService(userDetailsService);
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
*/
