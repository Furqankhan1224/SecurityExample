package com.test.confi;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties.ConfigureAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.test.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@SuppressWarnings({ "deprecation", "removal" })
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
        .csrf().disable()
            .cors().disable()
            .authorizeRequests(authorize -> {
                authorize
                    .requestMatchers(new AntPathRequestMatcher("/public/**"))
                    .permitAll()
                    .anyRequest().authenticated();
            })
            .formLogin();

        return httpSecurity.build();
	}
    protected void configure(AuthenticationManagerBuilder http) throws Exception {
        http.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//    	
//		return customUserDetailsService;
////        UserDetails user1 = User.withDefaultPasswordEncoder()
////            .username("furqan")
////            .password("1234")
////            .roles("ADMIN")
////            .build();
////
////        UserDetails user2 = User.withDefaultPasswordEncoder()
////            .username("khan")
////            .password("123")
////            .roles("ADMIN")
////            .build();
////
////        return new InMemoryUserDetailsManager(user1, user2);
//    }
  @Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder(10);
 	
 }
}

