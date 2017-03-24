package com.springboot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		//.anyRequest().authenticated()
		//.antMatchers("/allStudents").access("hasRole('ROLE_ADMIN')")
		.and()
		.formLogin().permitAll().and()
		.logout().permitAll();
		
//		http.authorizeRequests().antMatchers("/hello").access("hasRole('ROLE_ADMIN')").anyRequest().permitAll().and()
//				.formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and()
//				.logout().logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/403").and()
//				.csrf();
		// http.authorizeRequests().antMatchers("/",
		// "/home").permitAll().anyRequest().authenticated().and().formLogin()
		// .loginPage("/login").permitAll().and().logout().permitAll();
	}

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception {
	 * auth.inMemoryAuthentication().withUser("user").password("password").roles
	 * ("USER"); }
	 */
}
