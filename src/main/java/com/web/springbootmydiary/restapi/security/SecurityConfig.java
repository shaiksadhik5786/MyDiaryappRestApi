package com.web.springbootmydiary.restapi.security;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    // Load users from database
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
    	UserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Optional: custom queries if your table names differ
        // manager.setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?");
        // manager.setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username=?");

        return userDetailsManager;
    }
    
 // Security rules
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.DELETE, "/entries/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/entries/**").hasRole("MANAGER")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())   // ✅ use HTTP Basic instead of form login
            .csrf(csrf -> csrf.disable()); // disable CSRF for APIs

        return http.build();
    }

}


/*
@Bean
InMemoryUserDetailsManager configInMemoryUser()
{
    UserDetails user1 = User.builder().username("sadhik").password("{noop}sadhik55").roles("Admin","EMployee").build();
    UserDetails user2 = User.builder().username("ravi").password("{noop}ravi11").roles("Manager").build();
    UserDetails user3 = User.builder().username("sai").password("{noop}sai22").roles("EMployee").build();
    
    InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,user2,user3);
    
    return inMemoryUserDetailsManager;
} 
*/
/*
// Password encoder (BCrypt)
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}


*/
