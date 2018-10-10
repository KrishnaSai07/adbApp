
package com.verizon.ep;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(2)
@EnableWebSecurity
public class SecurityConfigurationUser extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/images/**");
       
    }
   
   
     
   
   
     @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
           
            auth.inMemoryAuthentication()
              .withUser("user")
              .password("{noop}userPass")
              .roles("USER");
        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
   
       
       
       
        http.antMatcher("/user**")
        .authorizeRequests()
        .anyRequest()
        .hasRole("USER");
       

        http.formLogin()
        .loginPage("/user/login")
        .loginProcessingUrl("/user_login")   
        .defaultSuccessUrl("/user/home")
        .failureUrl("/login?err=true")
        .usernameParameter("unm")
        .passwordParameter("pwd");
       
        http.logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/")
        .and()
        .exceptionHandling()
        .accessDeniedPage("/403")
        .and()
        .csrf().disable();
    }
   

}