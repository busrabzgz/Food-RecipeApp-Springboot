package com.example.yemekTarifi.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.formLogin();
        http.authorizeHttpRequests().antMatchers("/dashboard").hasAnyRole("admin","user")
                .antMatchers("/admin").hasRole("admin")
                .and()
                .authorizeHttpRequests()
                .antMatchers("/index")
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //{bcyrpt},{pbkdf2} edebilirdim
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}1234").roles("admin")
                .and().withUser("user").password("{noop}1234").roles("user");
    }
}
