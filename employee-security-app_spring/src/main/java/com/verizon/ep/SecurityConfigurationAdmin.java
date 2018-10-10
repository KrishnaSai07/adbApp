/*package com.verizon.ep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationAdmin extends WebSecurityConfigurerAdapter {


	@Override
	public void configure(WebSecurity web) throws Exception {
	
		web.ignoring().antMatchers("/css/**","/js/**","/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		//http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER").and().httpBasic().authenticated();
		
		http.formLogin().loginPage("/login").defaultSuccessUrl("/admin").failureUrl("/login?err=true").usernameParameter("unm").passwordParameter("pwd");
		http.formLogin().loginPage("/loginUser").defaultSuccessUrl("/user").failureUrl("/login?err=true").usernameParameter("unm").passwordParameter("pwd");
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	   
	    //http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER").anyRequest().authenticated();
	   
	}
	 
	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

	        auth.inMemoryAuthentication()
	                .withUser("user").password("{noop}password").roles("USER")
	                .and()
	                .withUser("admin").password("{noop}password").roles("ADMIN");
	    }
	

	
}*/

package com.verizon.ep;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@Order(1)
@EnableWebSecurity
public class SecurityConfigurationAdmin extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/images/**");
       
    }
   
   
     
   
     @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
              .withUser("admin")
              .password("{noop}adminPass")
              .roles("ADMIN");
         }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
   
        http.antMatcher("/admin**")
        .authorizeRequests()
        .anyRequest()
        .hasRole("ADMIN");

        System.out.println("hello");
        http.formLogin()
        .loginPage("/admin/login")
        .loginProcessingUrl("/admin_login")
        .defaultSuccessUrl("/admin/home")
        .failureUrl("/login?err=true")
        .usernameParameter("unm")
        .passwordParameter("pwd");
        System.out.println("hello");

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

